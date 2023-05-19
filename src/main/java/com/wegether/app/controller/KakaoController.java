package com.wegether.app.controller;

import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.account.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {

    private final KakaoService kakaoService;

    private final AccountService accountService;

    @GetMapping("/login")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        log.info("들어옴");
        log.info(code);
        String token = kakaoService.getKaKaoAccessToken(code);
        log.info(token);
        session.setAttribute("token", token);
        HashMap<String, Object> kakaoInfo = kakaoService.getKakaoInfo(token);


//    카카오 로그인 한적 없을때
        if(!accountService.checkId(kakaoInfo.get("memberId").toString()).isPresent()){
            redirectAttributes.addAttribute("memberId", kakaoInfo.get("memberId").toString());
            redirectAttributes.addAttribute("memberPassword", kakaoInfo.get("memberPassword").toString());
            return new RedirectView("/accounts/kakao-register");
        }

//        카카오 로그인해서 db에 계정이 있을때
        accountService.login(kakaoInfo.get("memberId").toString(), kakaoInfo.get("memberPassword").toString());

        return new RedirectView("/index/main");

    }

    @GetMapping("/logout")
    public void kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
    }
}
