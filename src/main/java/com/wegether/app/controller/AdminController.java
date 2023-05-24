package com.wegether.app.controller;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.*;
import com.wegether.app.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admins/*")
public class AdminController {
    private final AdminService adminService;

/* -------------------------------------------------------- */

    //    공지사항 등록 이동
    @GetMapping("notice/write")
    public void goToNoticeWriteForm(NoticeVO noticeVO){;}

    //    공지사항 작성
    @PostMapping("notice/write")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView noticeWrite(NoticeVO noticeVO){
        adminService.noticeWrite(noticeVO);
        return new RedirectView("/admins/notice/list");
    }

    //    공지사항 목록 이동
    @GetMapping("notice/list")
    public void noticeList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getNoticeTotal(search));
        adminPagination.progress();
        model.addAttribute("notices", adminService.noticeGetList(adminPagination, search));
    }

    //    공지사항 상세
    @GetMapping("notice/detail")
    public void readNoticeDetail(Long id, Model model){
        Optional<NoticeAdminDTO> readNoticeVO = adminService.noticeRead(id);
        if(readNoticeVO.isPresent()) {
            model.addAttribute("noticeBoards", readNoticeVO.get());
        }
    }

    //    공지사항 수정 이동
    @GetMapping("notice/modify")
    public void goToModifyForm(NoticeVO noticeVO, Model model, Long id){
        Optional<NoticeAdminDTO> readNoticeVO = adminService.noticeRead(id);
        model.addAttribute("noticeBoards", readNoticeVO.get());
    }

    //    공지사항 수정
    @PostMapping("notice/modify")
    public RedirectView noticeModify(NoticeVO noticeVO){
        adminService.noticeModify(noticeVO);
        return new RedirectView("/admins/notice/list");
    }

    //    공지사항 삭제
    @PostMapping("notice/delete")
    @ResponseBody
    public void noticeRemove(@RequestBody List<String> noticeIds) {
        for (String noticeId : noticeIds) adminService.noticeRemove(Long.valueOf(noticeId));
    }

/* -------------------------------------------------------- */

    //    문의사항 목록 이동
    @GetMapping("inquiry/list")
    public void inquiryList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getInquiryTotal(search));
        adminPagination.progress();
        model.addAttribute("inquiries", adminService.inquiryGetList(adminPagination, search));
    }

    //    문의사항 상세
    @GetMapping("inquiry/detail")
    public void readInquiryDetail(Long id, Model model){
        Optional<InquiryAdminDTO> readInquiryAdminDTO = adminService.inquiryRead(id);
        if(readInquiryAdminDTO.isPresent()) {
            model.addAttribute("inquiryBoards", readInquiryAdminDTO.get());
        }
    }

    //    문의사항 답변 등록 이동
    @GetMapping("inquiry/write")
    public void goToAnswerWriteForm(AnswerVO answerVO, Model model, Long id){
        Optional<InquiryAdminDTO> readInquiryAdminDTO = adminService.inquiryRead(id);
        if(readInquiryAdminDTO.isPresent()) {
            model.addAttribute("inquiryBoards", readInquiryAdminDTO.get());
        }
    }

    //    문의사항 답변 등록
    @PostMapping("inquiry/write")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView answerWrite(AnswerVO answerVO, @RequestParam("inquiryId") long id){
            adminService.answerWrite(answerVO);
            adminService.inquiryStatusChange(id);
            return new RedirectView("/admins/inquiry/list");
        }

    //    문의사항 답변 상세 이동
    @GetMapping("inquiry/answer-detail")
    public void readAnswerDetail(Long id, Model model, AnswerAdminDTO answerAdminDTO){
        Optional<AnswerAdminDTO> readAnswerAdminDTO = adminService.answerRead(id);
        if(readAnswerAdminDTO.isPresent()) {
          model.addAttribute("answerBoards", readAnswerAdminDTO.get());
        };
    }

    //    문의사항 답변 수정 상세 이동
    @GetMapping("inquiry/modify")
    public void goToAnswerModifyForm(AnswerAdminDTO answerAdminDTO, Model model, Long id){
        Optional<AnswerAdminDTO> readAnswerAdminDTO = adminService.answerModifyRead(id);
        if(readAnswerAdminDTO.isPresent()) {
            model.addAttribute("answerModifyBoards", readAnswerAdminDTO.get());
        }
    }

    //    문의사항 답변 수정
    @PostMapping("inquiry/modify")
    public RedirectView answerModify(AnswerAdminDTO answerAdminDTO){
        adminService.answerModify(answerAdminDTO);
        return new RedirectView("/admins/inquiry/list");
    }

    //    문의사항 삭제
    @PostMapping("inquiry/delete")
    @ResponseBody
    public void answerRemove(@RequestBody List<String> dataIds) {
        for (String dataId : dataIds) adminService.answerRemove(Long.valueOf(dataId));
    }


/* -------------------------------------------------------- */

    //    자료 목록 이동
    @GetMapping("data/list")
    public void dataList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getDataTotal(search));
        adminPagination.progress();
        model.addAttribute("datas", adminService.dataGetList(adminPagination, search));
    }

    //    자료 삭제
    @PostMapping("data/delete")
    @ResponseBody
    public void dataRemove(@RequestBody List<String> inquiryIds) {
        for (String inquiryId : inquiryIds) adminService.dataRemove(Long.valueOf(inquiryId));
    }

/* -------------------------------------------------------- */

    //    프로젝트 목록 이동
    @GetMapping("project/list")
    public void projectList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getProjectTotal(search));
        adminPagination.progress();
        model.addAttribute("projects", adminService.projectGetList(adminPagination, search));
    }

    //    프로젝트 삭제
    @PostMapping("project/delete")
    @ResponseBody
    public void projectRemove(@RequestBody List<String> projectIds) {
        for (String projectId : projectIds) adminService.projectRemove(Long.valueOf(projectId));
    }

/* -------------------------------------------------------- */

    //    강연 목록 이동
    @GetMapping("lecture/list")
    public void lectureList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getLectureTotal(search));
        adminPagination.progress();
        model.addAttribute("lectures", adminService.lectureGetList(adminPagination, search));
    }

    //    강연 삭제
    @PostMapping("lecture/delete")
    @ResponseBody
    public void lectureRemove(@RequestBody List<String> lectureIds) {
        for (String lectureId : lectureIds) adminService.lectureRemove(Long.valueOf(lectureId));
    }
    

/* -------------------------------------------------------- */

    //    회원 목록 이동
    @GetMapping("member/list")
    public void memberList(Model model, AdminPagination adminPagination, Search search){
        adminPagination.setTotal(adminService.getMemberTotal(search));
        adminPagination.progress();
        model.addAttribute("members", adminService.memberGetList(adminPagination, search));
    }

    //    회원 상태 변경
    @PostMapping("member/delete")
    @ResponseBody
    public void memberRemove(@RequestBody List<String> memberIds) {
        for (String memberId : memberIds) adminService.memberRemove(Long.valueOf(memberId));
    }

/* -------------------------------------------------------- */



}





















