package com.wegether.app.controller;

import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.account.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {

    private final KakaoService kakaoService;

    private final AccountService accountService;


    @GetMapping("/login")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        String token = kakaoService.getKaKaoAccessToken(code);
        session.setAttribute("token", token);
        HashMap<String, Object> kakaoInfo = kakaoService.getKakaoInfo(token);


        //애초에 카카오 로그인 할때 그 아이디가 있을때 중복이고 그 계정이 카카오 연동이 아닐떄

        //카카오 계정 로그인 할떄 이미 아이디가 일반 회원이나 네이버로 가입되어있을경우
        if (accountService.checkId(kakaoInfo.get("memberId").toString()).isPresent()) {
            Optional<MemberVO> foundMember = accountService.checkId(kakaoInfo.get("memberId").toString());
            foundMember.ifPresent(member -> {
                if (member.getMemberLoginStatus().equals("WEGETHER")) {
//                회원의 계정을 카카오 계정으로 변경(연동)
                    accountService.changeLoginStatusToKakao((String) session.getAttribute("id"));
                }
            });
        }



//    카카오 로그인 한적 없을때
        if(!accountService.checkId(kakaoInfo.get("memberId").toString()).isPresent()){
            log.info("아래");
            log.info(kakaoInfo.get("memberId").toString());
            redirectAttributes.addFlashAttribute("memberId", kakaoInfo.get("memberId").toString());
            redirectAttributes.addFlashAttribute("memberPassword", kakaoInfo.get("memberPassword").toString());
            return new RedirectView("/accounts/kakao-register");
        }

//        카카오 로그인해서 db에 계정이 있을때
        Optional<Long> foundNumber = accountService.login(kakaoInfo.get("memberId").toString(), kakaoInfo.get("memberPassword").toString());
        if(foundNumber.isPresent()){
            session.setAttribute("id", foundNumber.get());
        }



        return new RedirectView("/index/main");
    }

    @GetMapping("/logout")
    public void kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
    }
}
