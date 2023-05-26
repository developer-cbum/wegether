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

    @GetMapping("list")
    public void list(){}

    @PostMapping("list")
    @ResponseBody
    public List<CommunityDTO> list(@RequestBody CommunityPagination communityPagination, Model model) {
        communityPagination.setTotal(communityService.getTotal());
        communityPagination.progress(1, 10);
        return communityService.getList(communityPagination);
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
    public void detail(@RequestParam Long id, Model model, CommunityReplyDTO communityReplyDTO){
        model.addAttribute("memberVO", accountService.getIdAndProfile((1L)).get());
        model.addAttribute("total", communityReplyService.getTotal(id));
        model.addAttribute("community", communityService.getCommunity(id).get());
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



















