package com.wegether.app.controller;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.community.CommunityService;
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
@RequestMapping("/community/*")
public class CommunityController {
    private final CommunityService communityService;
    private final AccountService accountService;

    @GetMapping("list")
    public void list(CommunityPagination communityPagination, Model model) {
        communityPagination.setTotal(communityService.getTotal());
        communityPagination.progress();
        model.addAttribute("communities", communityService.getList(communityPagination));
    }

    @GetMapping("write")
    public void goToRegisterForm(CommunityDTO communityDTO, Model model) {
        ;
    }

    @PostMapping("write")
    public RedirectView register(CommunityDTO communityDTO) {
        communityService.write(communityDTO);
        return new RedirectView("/community/list");
    }

    @GetMapping(value = {"detail", "modify"})
    public void detail(@RequestParam Long id, Model model){
        model.addAttribute("community", communityService.getCommunity(id).get());
    }


    @PostMapping("modify")
    public RedirectView modify(CommunityDTO communityDTO, RedirectAttributes redirectAttributes){
        log.info(communityDTO.toString());
        communityService.modify(communityDTO);
        redirectAttributes.addAttribute("id", communityDTO.getId());
        log.info(communityDTO.toString());
        return new RedirectView("/community/detail");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public RedirectView remove(Long id){
        communityService.remove(id);
        return new RedirectView("/community/list");
    }

}



















