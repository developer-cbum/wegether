package com.wegether.app.controller;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.community.CommunityReplyService;
import com.wegether.app.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {
    private final CommunityService communityService;
    private final AccountService accountService;
    private final CommunityReplyService communityReplyService;
    private final HttpSession session;

    @GetMapping("list")
    public void list(){}

    @PostMapping("list")
    @ResponseBody
    public List<CommunityDTO> list(@RequestBody CommunityPagination communityPagination, Model model) {
        log.info(communityPagination.toString());
        communityPagination.setPage(communityPagination.getPage());
        communityPagination.setKeyword(communityPagination.getKeyword());
        communityPagination.setTotal(communityService.getTotal(communityPagination));
        communityPagination.progress(1, 9);
        log.info("======리스트 출력부=======" + communityService.getList(communityPagination).toString());
        return communityService.getList(communityPagination);
    }

    @GetMapping("write")
    public void goToRegisterForm(CommunityDTO communityDTO, Model model) {
        ;
    }

    @PostMapping("write")
    public RedirectView register(CommunityDTO communityDTO, HttpSession session) {
        communityDTO.setMemberId((Long) session.getAttribute("id"));
        communityService.write(communityDTO);
        return new RedirectView("/community/list");
    }

    @GetMapping(value = {"detail", "modify"})
    public void detail(@RequestParam Long id, Model model, CommunityReplyDTO communityReplyDTO){
        if(session.getAttribute("id") != null){
            model.addAttribute("memberVO", accountService.getIdAndProfile((Long)session.getAttribute("id")).get());
        }
        model.addAttribute("total", communityReplyService.getTotal(id));
        model.addAttribute("community", communityService.getCommunity(id).get());
        model.addAttribute("basicReplyTotal", communityReplyService.getTotal(id));
        log.info("===========" + communityReplyDTO);
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
        communityReplyService.removeAll(communityService.getCommunity(id).get().getId());
        communityService.remove(id);
        return new RedirectView("/community/list");
    }

}



















