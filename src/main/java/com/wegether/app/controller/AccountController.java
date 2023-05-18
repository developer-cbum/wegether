package com.wegether.app.controller;

import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.mail.RegisterMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account/*")
public class AccountController {

    //계정
    private final AccountService accountService;

    //메일
    private final RegisterMailService registerMailService;

//    회원가입 화면으로 이동
    @GetMapping("register")
    public void goToJoinForm(MemberVO memberVO){;}

// 회원가입 완료
    @PostMapping("register")
    public RedirectView join(MemberVO memberVO){
        accountService.join(memberVO);
        return new RedirectView("/account/login/login");
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
            return new RedirectView("/account/login");

        }

    //    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/account/login");
    }


    //    아이디중복검사
    @PostMapping("checkId")
    @ResponseBody
    public boolean checkId(MemberVO memberVO){
        Optional<MemberVO> foundMemberVO = accountService.checkId(memberVO.getMemberId());
        if(foundMemberVO.isEmpty()){
            return true;
        }
        return false;
    }

    // 회원 가입 메일인증
    @PostMapping("mailConfirm")
    @ResponseBody
    public String mailConfirm(String memberId) throws Exception{
        String code = registerMailService.sendSimpleMessage(memberId);
        log.info("인증 코드 :" + code);
        return code;

    }

    //아이디찾기
    @GetMapping("find/id")
    public void goToFindIdForm(){;}

    @PostMapping("findId")
    @ResponseBody
    public boolean findId(String memberId){
        Optional<MemberVO> foundMember = accountService.checkId(memberId);
        if(foundMember.isEmpty()){
            return false;
        }
        return true;
    }

    //비밀번호찾기
    @GetMapping("find/pwd")
    public void goToFindPwForm(){;}


}





















