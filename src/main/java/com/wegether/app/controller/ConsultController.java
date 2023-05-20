package com.wegether.app.controller;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.consult.ConsultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public void goToConsultingList(Pagination pagination, Search search, Model model){
        pagination.setTotal(consultService.getTotal(search));
        pagination.progress();
        model.addAttribute("consults", consultService.getList(pagination, search));
        }

    @GetMapping("detail")
    public void goToConsultingDetail(@RequestParam Long id, Model model, HttpSession session){
        log.info(consultService.getConsulting(id).get().toString());
        model.addAttribute("consultDTO", consultService.getConsulting(id).get());
    }

    @GetMapping("modify")
    public void goToConsultingModify(@RequestParam Long id, Model model, HttpSession session){
        log.info(consultService.getConsulting(id).get().toString());
        model.addAttribute("consultDTO", consultService.getConsulting(id).get());
        String nickName = accountService.getMemberById((Long)session.getAttribute("id")).get().getMemberNickname();
        model.addAttribute("nickName", nickName);
    }


    @PostMapping("modify")
    public RedirectView modify(ConsultingDTO consultingDTO, RedirectAttributes redirectAttributes){
        log.info(consultingDTO.toString());
        consultService.modifyConsulting(consultingDTO);
        redirectAttributes.addAttribute("id", consultingDTO.getId());
        return new RedirectView("/consults/detail");
    }

    @GetMapping("remove")
    public RedirectView remove(@RequestParam Long id){
        consultService.removeConsulting(id);
        return new RedirectView("/consults/list");
    }

}





















