package com.wegether.app.controller;

import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;


//    공지사항 작성 이동
    @GetMapping("notice/write")
    public void goToWriteForm(NoticeVO noticeVO){;}

//    공지사항 목록 이동
    @GetMapping("notice/list")
    public void goToListForm(NoticeVO noticeVO){;}

//    공지사항 상세 이동
    @GetMapping("notice/detail")
    public void goToDetailForm(NoticeVO noticeVO){;}

//    공지사항 수정 이동
    @GetMapping("notice/modify")
    public void goToModifyForm(NoticeVO noticeVO){;}



}





















