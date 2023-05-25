package com.wegether.app.controller;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.NoticeAdminDTO;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notices/*")
public class NoticeController {
    private final AdminService adminService;

    //    공지사항 목록 이동
    @GetMapping("list")
    public void noticeList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getNoticeTotal(search));
        adminPagination.progress();
        model.addAttribute("notices", adminService.noticeGetList(adminPagination, search));
    }

    //    공지사항 상세
    @GetMapping("detail")
    public void readNoticeDetail(Long id, Model model){
        Optional<NoticeAdminDTO> readNoticeVO = adminService.noticeRead(id);
        if(readNoticeVO.isPresent()) {
            model.addAttribute("noticeBoards", readNoticeVO.get());
        }
    }
}





















