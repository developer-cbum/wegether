package com.wegether.app.controller;

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


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/index/*")
public class MainController {
    private final MainService mainService;


    @GetMapping("main")
    public void goToListForm(Model model){
        model.addAttribute("projects", mainService.mainPGetList());

    }


}





















