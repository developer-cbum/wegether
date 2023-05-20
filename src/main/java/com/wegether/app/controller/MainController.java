package com.wegether.app.controller;

import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.service.inquiry.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {







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





















