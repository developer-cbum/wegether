package com.wegether.app.controller;


import com.wegether.app.domain.dto.MainPagination;
import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.service.inquiry.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.service.main.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.File;
import java.io.IOException;
import java.util.List;



@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/index/*")
public class MainController {
    private final MainService mainService;


    @GetMapping("main")
    public void goToListForm(Model model){
//        List<MainDTO> projects = mainService.mainPGetList();
//        List<MainDTO> datas = mainService.mainDGetList();
//        List<MainDTO> communities = mainService.mainCGetList();
        model.addAttribute("projects", mainService.mainPGetList());
        model.addAttribute("datas", mainService.mainDGetList());
        model.addAttribute("datards", mainService.mainDRGetList());
        model.addAttribute("communities", mainService.mainCGetList());

    }


    @GetMapping("search-list")
    public void goToSearch(Model model, MainPagination mainPagination){
        model.addAttribute("searches", mainService.mainSPGetList(mainPagination));
    }

    @GetMapping("search-test")
    public void goToList(Model model, MainPagination mainPagination){
        model.addAttribute("searchtest", mainService.mainSDGetList(mainPagination));
    }



//    1:1 문의
    private final InquiryService inquiryService;

    @GetMapping("/inquiry-register")
//    문의 작성 완료
    @PostMapping("write")
    public RedirectView write(InquiryVO inquiryVO){
        inquiryService.register(inquiryVO);
        return new RedirectView("");
    }
}

























