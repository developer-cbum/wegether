package com.wegether.app.controller;

import com.wegether.app.domain.vo.ConsultingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/consults/*")
public class ConsultController {

    @GetMapping("register")
    public void goToRegisterForm(ConsultingVO consultingVO){};

    @PostMapping("register")
    public void register(){

    }
}





















