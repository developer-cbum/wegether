package com.wegether.app.controller;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.vo.*;
import com.wegether.app.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admins/*")
public class AdminController {
    private final AdminService adminService;

/* -------------------------------------------------------- */

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

/* -------------------------------------------------------- */

    //    문의사항 답변 작성 이동
    @GetMapping("inquiry/answer")
    public void goToWriteForm(InquiryVO inquiryVO){;}

    //    문의사항 목록 이동
    @GetMapping("inquiry/list")
    public void goToListForm(InquiryVO inquiryVO){;}

    //    문의사항 상세 이동
    @GetMapping("inquiry/detail")
    public void goToDetailForm(InquiryVO inquiryVO){;}

    //    문의사항 수정 이동
    @GetMapping("inquiry/modify")
    public void goToModifyForm(InquiryVO inquiryVO){;}

/* -------------------------------------------------------- */

    //    자료 목록 이동
//    @GetMapping("data/list")
//    public void goToListForm(DataAdminDTO dataAdminDTO){;}

    @GetMapping("data/list")
    public void list(Model model, AdminPagination adminPagination){
        adminPagination.setTotal(adminService.getDataTotal());
        adminPagination.progress();
        model.addAttribute("datas", adminService.dataGetList(adminPagination));
    }

    // 자료 삭제
    @PostMapping("data/delete")
    @ResponseBody
    public void remove(@RequestBody List<String> dataIds) {
        for (String dataId : dataIds) adminService.dataRemove(Long.valueOf(dataId));
    }


//    @PostMapping("data/delete")
//    public RedirectView remove(Long id) { adminService.dataRemove(id); return new RedirectView("admins/data/list");}


/* -------------------------------------------------------- */

    //    프로젝트 목록 이동
    @GetMapping("project/list")
    public void goToListForm(ProjectVO projectVO){;}

/* -------------------------------------------------------- */

    //    강연 목록 이동
    @GetMapping("lecture/list")
    public void goToListForm(LectureVO lectureVO){;}

/* -------------------------------------------------------- */

    //    회원 목록 이동
    @GetMapping("member/list")
    public void goToListForm(MemberVO memberVO){;}

/* -------------------------------------------------------- */



}





















