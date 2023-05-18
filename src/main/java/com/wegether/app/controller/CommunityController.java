package com.wegether.app.controller;

import com.wegether.app.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community/*")
public class CommunityController {
    private CommunityService communityService;

    @GetMapping("community-detail")
    public void read(Long id, Model model){
        model.addAttribute("detail", communityService.getCommunity(id));
    }

}





















