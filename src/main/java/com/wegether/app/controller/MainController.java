package com.wegether.app.controller;


import com.wegether.app.domain.dto.MainDataPagination;
import com.wegether.app.domain.dto.MainProjectPagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.service.inquiry.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.wegether.app.service.main.MainService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void goToListForm(Model model, @RequestParam(required = false) String sns){

        if(sns !=null){
            model.addAttribute("snsStatus", sns);
        }
//        List<MainDTO> projects = mainService.mainPGetList();
//        List<MainDTO> datas = mainService.mainDGetList();
//        List<MainDTO> communities = mainService.mainCGetList();
        model.addAttribute("projects", mainService.mainPGetList());
        model.addAttribute("datas", mainService.mainDGetList());
        model.addAttribute("datards", mainService.mainDRGetList());
        model.addAttribute("communities", mainService.mainCGetList());

    }

//    @GetMapping("search-list")
//    public void goToSearch(Model model, MainPagination mainPagination, Search search){
//        mainPagination.setTotal(mainService.getProjectTotal(search));
//        mainPagination.progress();
//        model.addAttribute("searches", mainService.mainSPGetList(mainPagination, search));
//
//    }

//    검색 목록
    @GetMapping("search-list")
    @Transactional(rollbackFor = Exception.class)
    public void goToSearch(Model model, MainProjectPagination mainProjectPagination, Search search, MainDataPagination mainDataPagination){
        model.addAttribute("searchproject", mainService.mainSPGetList(mainProjectPagination, search));
        model.addAttribute("searchdata", mainService.mainSDGetList(mainDataPagination, search));

    }

//    @PostMapping("search-project-list")
//    @ResponseBody
//    public List<MainDTO> gotoSearchProject(@RequestBody MainPagination mainPagination, @RequestBody Search search ){
//        mainPagination.setTotal(mainService.getProjectTotal(search));
//        mainPagination.progress();
//        return mainService.mainSPGetList(mainPagination, search);
//    }
////
//    @PostMapping("search-data-list")
//    @ResponseBody
//    public List<MainDTO> gotoSearchData(@RequestBody MainPagination mainPagination, @RequestBody Search search){
//        mainPagination.setTotal(mainService.getDataTotal(search));
//        mainPagination.progress();
//        return mainService.mainSDGetList(mainPagination,search);
//    }

//    @GetMapping("search-test")
//    public void goToList(Model model, MainPagination mainPagination, Search search){
//        mainPagination.setTotal(mainService.getProjectTotal(search));
//        mainPagination.progress();
//        model.addAttribute("searches", mainService.mainSPGetList(mainPagination, search));
//    }

    //        mainPagination.setTotal(mainService.getProjectTotal(search));
//        mainPagination.progress();
//        model.addAttribute("searches", mainService.mainSDGetList(mainPagination, search));
//        model.addAttribute("searches", mainService.mainSDGetList(mainPagination, search));





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

























