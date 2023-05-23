package com.wegether.app.dao.admin;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.domain.dto.AnswerAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.vo.AnswerVO;
import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class adminDAOTests {

    @Autowired
    private AdminDAO adminDAO;

    /* ------------------------------------------------------------------------------------ */

    //    공지사항 목록 테스트
//    @Test
//    public void noticeFindAllTest() {
//        assertThat(adminDAO.noticeFindAll()).hasSize(2);
//    }

    //    공지사항 등록 테스트
    @Test
    public void noticeSaveTest() {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("공지사항 테스트 제목");
        noticeVO.setNoticeContent("공지사항 테스트 내용");
        adminDAO.noticeSave(noticeVO);
    }

    //    공지사항 상세 테스트
    @Test
    public void noticeFindByIdTest() {
        adminDAO.noticeFindById(21L).map(NoticeVO::getNoticeTitle).ifPresent(log::info);
    }

    //    공지사항 수정 테스트
    @Test
    public void setNoticeVOTest() {
        adminDAO.noticeFindById(21L).ifPresent(noticeVO -> {
            noticeVO.setNoticeTitle("공지사항 제목 수정21");
            adminDAO.setNoticeVO(noticeVO);
        });
    }

    //    공지사항 삭제 테스트
    @Test
    public void noticeDeleteTest() {
        adminDAO.noticeDelete(22L);
    }

    /* ------------------------------------------------------------------------------------ */


//    @Test
//    public void dataFindAllTest() { assertThat(adminDAO.dataFindAll()).hasSize(2); }

    //    자료 삭제 테스트
    @Test
    public void dataDeleteTest() { adminDAO.dataDelete(1L);}

    /* ------------------------------------------------------------------------------------ */

    //    프로젝트 목록 테스트
//    @Test
//    public void projectFindAllTest() { assertThat(adminDAO.projectFindAll()).hasSize(2); }

    //    프로젝트 삭제 테스트
    @Test
    public void projectDeleteTest() { adminDAO.projectDelete(1L);}

    /* ------------------------------------------------------------------------------------ */

    //    문의사항 목록 테스트
//    @Test
//    public void inquiryFindAllTest() {
//        assertThat(adminDAO.inquiryFindAll()).hasSize(1);
//    }

    //    문의사항 답변 등록 테스트
    @Test
    public void answerSaveTest() {
        AnswerVO answerVO = new AnswerVO();
        answerVO.setAnswerContent("답변 내용");
        answerVO.setInquiryId(1L);
        adminDAO.answerSave(answerVO);
    }

    //    문의사항 상세 테스트
    @Test
    public void inquiryFindByIdTest() {
        adminDAO.inquiryFindById(1L).map(InquiryAdminDTO::getInquiryTitle).ifPresent(log::info);
    }

    //    문의사항 답변 상세 테스트
    @Test
    public void answerFindByIdTest() {
        adminDAO.answerFindById(41L).map(AnswerAdminDTO::toString).ifPresent(log::info);
    }

    //    문의사항 답변 수정 테스트
//    @Test
//    public void setAnswerVOTest() {
//        adminDAO.answerFindById(5L).ifPresent(answerVO -> {
//            answerVO.setAnswerContent("수정 다오 테스트");
//            adminDAO.setAnswerVO(answerVO);
//        });
//    }

    //    문의사항 답변 삭제 테스트
    @Test
    public void answerDeleteTest() {
        adminDAO.answerDelete(1L);
    }

    /* ------------------------------------------------------------------------------------ */

    //    회원 목록 테스트
//    @Test
//    public void memberFindAllTest() { assertThat(adminDAO.memberFindAll()).hasSize(3); }

    //    회원 삭제 테스트
    @Test
    public void memberDeleteTest() { adminDAO.memberDelete(3L);}

    /* ------------------------------------------------------------------------------------ */

    //    강연 목록 테스트
//    @Test
//    public void lectureFindAllTest() { assertThat(adminDAO.lectureFindAll()).hasSize(2); }

    //    강연 삭제 테스트
    @Test
    public void lectureDeleteTest() { adminDAO.lectureDelete(3L);}

    /* ------------------------------------------------------------------------------------ */
}
