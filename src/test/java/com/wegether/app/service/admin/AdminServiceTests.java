package com.wegether.app.service.admin;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.vo.AnswerVO;
import com.wegether.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class AdminServiceTests {

    @Autowired
    private AdminService adminService;

    /* ------------------------------------------------------------------------------------ */

    //    공지사항 목록 테스트
    @Test
    public void noticeGetListTest(){
        assertThat(adminService.noticeGetList()).hasSize(2);
    };

    //    공지사항 등록 테스트
    @Test
    public void noticeWriteTest() {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("공지사항 테스트 제목50");
        noticeVO.setNoticeContent("공지사항 테스트 내용50");
        adminService.noticeWrite(noticeVO);
    }

    //    공지사항 상세 테스트
    @Test
    public void noticeReadTest() {
        adminService.noticeRead(23L).map(NoticeVO::getNoticeTitle).ifPresent(log::info);
    }

    //    공지사항 수정 테스트
    @Test
    public void noticeModifyTest() {
        adminService.noticeRead(23L).ifPresent(noticeVO -> {
            noticeVO.setNoticeTitle("공지사항 제목 수정 55");
            adminService.noticeModify(noticeVO);
        });
    }

    //    공지사항 삭제 테스트
    @Test
    public void noticeRemoveTest() {
        adminService.noticeRemove(23L);
    }

    /* ------------------------------------------------------------------------------------ */

    //    자료 목록 테스트
//    @Test
//    public void dataGetListTest() { assertThat(adminService.dataGetList()).toString(); }

//    @Test
//    public void dataGetListTest() {
//        adminService.dataGetList().stream().map(DataAdminDTO::toString).forEach(log::info);
//    }

    //    자료 삭제 테스트
    @Test
    public void dataRemoveTest() { adminService.dataRemove(2L);}

    /* ------------------------------------------------------------------------------------ */

    //    프로젝트 목록 테스트
    @Test
    public void projectGetListAllTest() { assertThat(adminService.projectGetList()).hasSize(1); }

    //    프로젝트 삭제 테스트
    @Test
    public void projectRemoveTest() { adminService.projectRemove(2L);}

    /* ------------------------------------------------------------------------------------ */

    //    문의사항 목록 테스트
    @Test
    public void inquiryGetListTest() {assertThat(adminService.inquiryGetList()).hasSize(1); }

    //    문의사항 답변 등록 테스트
    @Test
    public void answerWriteTest() {
        AnswerVO answerVO = new AnswerVO();
        answerVO.setAnswerContent("답변 들어갑니다");
        answerVO.setInquiryId(1L);
        adminService.answerWrite(answerVO);
    }

    //    문의사항 상세 테스트
    @Test
    public void inquiryReadTest() {
        adminService.inquiryRead(1L).map(InquiryAdminDTO::getInquiryTitle).ifPresent(log::info);
    }

    //    문의사항 답변 상세 테스트
    @Test
    public void answerReadTest() {
        adminService.answerRead(1L).map(AnswerVO::getAnswerContent).ifPresent(log::info);
    }

    //    문의사항 답변 수정 테스트
    @Test
    public void answerModifyTest() {
        adminService.answerRead(1L).ifPresent(answerVO -> {
            answerVO.setAnswerContent("수정 서비스 테스트");
            adminService.answerModify(answerVO);
        });
    }

    //    문의사항 답변 삭제 테스트
    @Test
    public void answerRemoveTest() { adminService.answerRemove(24L); }

    /* ------------------------------------------------------------------------------------ */

    //    회원 목록 테스트
    @Test
    public void memberGetListTest() { assertThat(adminService.memberGetList()).hasSize(2); }

    //    회원 삭제 테스트
    @Test
    public void memberRemoveTest() { adminService.memberRemove(2L);}

    /* ------------------------------------------------------------------------------------ */

    //    강연 목록 테스트
    @Test
    public void lectureGetListTest() { assertThat(adminService.lectureGetList()).hasSize(1); }

    //    강연 삭제 테스트
    @Test
    public void lectureRemoveTest() { adminService.lectureRemove(1L);}

    /* ------------------------------------------------------------------------------------ */

}
