package com.wegether.app.controller;

import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.consult.ConsultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consults/*")
public class ConsultController {

    private final ConsultService consultService;

    private final AccountService accountService;

    @GetMapping("register")
    public void goToRegisterForm(ConsultingVO consultingVO, HttpSession session, Model model){
       String nickName = accountService.getMemberById((Long) session.getAttribute("id")).get().getMemberNickname();
       model.addAttribute("nickName", nickName);
    };

    @PostMapping("register")
    public RedirectView register(ConsultingVO consultingVO, HttpSession session){
        consultingVO.setMemberId((Long)session.getAttribute("id"));
        consultService.register(consultingVO);
        return new RedirectView("/consults/list");
    }

    @GetMapping("list")
    public void goToConsultingList(){;}
}





















