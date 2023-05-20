package com.wegether.app.controller;

import com.wegether.app.service.mypage.CardImpl;
import com.wegether.app.service.mypage.InquiryImpl;
import com.wegether.app.service.mypage.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")

public class MypageController {


    private final CardImpl card;

    @GetMapping("card")
    public void cardRegister(){


    }
//    카드 등록 화면
    @GetMapping("/pay-card")
    public void goToWriteForm(CardVO cardVO){;}

    @PostMapping("write")
    public RedirectView write(PostVO postVO){
        postService.write(postVO);
        return new RedirectView("/post/list");
    }





}


















