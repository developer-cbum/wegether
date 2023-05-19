package com.wegether.app.controller;

import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.mail.ChangePwSendMailService;
import com.wegether.app.service.mail.RegisterMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/accounts/*")
public class AccountController {

    //계정
    private final AccountService accountService;

    // 인증코드 메일
    private final RegisterMailService registerMailService;

    // 비밀번호 재설정 메일
    private final ChangePwSendMailService changePwSendMailService;


//    회원가입 화면으로 이동
    @GetMapping("register")
    public void goToJoinForm(MemberVO memberVO){;}

// 회원가입 완료
    @PostMapping("register")
    public RedirectView join(MemberVO memberVO){
        accountService.join(memberVO);
        return new RedirectView("/account/login");
    }

    // 카카오 회원가입
    @GetMapping("kakao-register")
    public void goToKakakJoinForm(String memberId, String memberPassword, MemberVO memberVO){;}

    @PostMapping("kakao-register")
    public RedirectView joinToKakao(MemberVO memberVO){
        accountService.join(memberVO);
        return new RedirectView("/index/main");
    }


//    로그인
        @GetMapping("login")
        public void goToLoginForm(MemberVO memberVO){;}

        @PostMapping("login")
        public RedirectView login(String memberId, String memberPassword, HttpSession session, RedirectAttributes redirectAttributes){
            Optional<Long> foundMember = accountService.login(memberId, memberPassword);
            if(foundMember.isPresent()){
                session.setAttribute("id", foundMember.get());
                log.info(session.getAttribute("id").toString());
                return new RedirectView("/index/main");
            }
            redirectAttributes.addFlashAttribute("login", "false");
            return new RedirectView("/accounts/login");

        }

    //    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/accounts/login");
    }


    //    아이디중복검사 // 아이디찾기
    @PostMapping("check-id")
    @ResponseBody
    public Optional<MemberVO> checkId(String memberId){
        log.info(memberId);
        Optional<MemberVO> foundMemberVO = accountService.checkId(memberId);
        return foundMemberVO;
    }

    // 회원 가입 메일인증
    @PostMapping("mail-confirm")
    @ResponseBody
    public String mailConfirm(String memberId) throws Exception{
        String code = registerMailService.sendSimpleMessage(memberId);
        log.info("인증 코드 :" + code);
        return code;

    }
    // 비밀번호 재설정 메일전송
    @PostMapping("change-pw")
    @ResponseBody
    public void sendChangePwMail(String memberId, Long id) throws Exception{
        log.info(id.toString());
        changePwSendMailService.sendSimpleMessage(memberId, id);
    }


    //아이디찾기
    @GetMapping("find/id")
    public void goToFindIdForm(){;}


    //비밀번호찾기
    @GetMapping("find/pwd")
    public void goToFindPwForm(){;}

    //비밀번호 재설정
    @GetMapping("find/change-pwd")
    public void goToChangePwForm(Long id, MemberVO memberVO, Model model){
        log.info(id.toString());
        model.addAttribute("id", id);

    }

    @PostMapping("find/change-pwd")
    public RedirectView changePassword(Long id, MemberVO memberVO){
        log.info(memberVO.getMemberPassword());
        log.info(id.toString());
        accountService.changePassword(Long.valueOf(id), memberVO.getMemberPassword());
        return new RedirectView("/accounts/login");
    }




}





















