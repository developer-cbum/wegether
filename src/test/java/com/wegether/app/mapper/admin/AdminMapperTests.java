package com.wegether.app.mapper.admin;

import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.dto.ProjectAdminDTO;
import com.wegether.app.domain.vo.AnswerVO;
import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class AdminMapperTests {

    @Autowired
    private AdminMapper adminMapper;

    /* ------------------------------------------------------------------------------------ */

    //    공지사항 목록 테스트
    @Test
    public void noticeSelectAllTest() {
        assertThat(adminMapper.noticeSelectAll()).hasSize(1);
    }

    //    공지사항 등록 테스트
    @Test
    public void noticeInsertTest() {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("공지사항 테스트 제목");
        noticeVO.setNoticeContent("공지사항 테스트 내용");
        adminMapper.noticeInsert(noticeVO);
    }

    //    공지사항 상세 테스트
    @Test
    public void noticeSelectTest() {
        adminMapper.noticeSelect(21L).map(NoticeVO::getNoticeTitle).ifPresent(log::info);
    }

    //    공지사항 수정 테스트
    @Test
    public void noticeUpdateTest() {
        adminMapper.noticeSelect(2L).ifPresent(noticeVO -> {
            noticeVO.setNoticeTitle("공지사항 제목 수정");
            adminMapper.noticeUpdate(noticeVO);
        });
    }

    //    공지사항 삭제 테스트
    @Test
    public void noticeDeleteTest() {
        adminMapper.noticeDelete(2L);
    }

    /* ------------------------------------------------------------------------------------ */

    //    자료 목록 테스트
//    @Test
//    public void dataSelectAllTest() { assertThat(adminMapper.dataSelectAll()).hasSize(1); }

//    @Test
//    public void dataSelectAllTest() {
//        adminMapper.dataSelectAll().stream().map(DataAdminDTO::toString).forEach(log::info);
//    }



    //    자료 삭제 테스트
    @Test
    public void dataDeleteTest() { adminMapper.dataDelete(1L);}


    /* ------------------------------------------------------------------------------------ */

    //    프로젝트 목록 테스트
//    @Test
//    public void projectSelectAllTest() { assertThat(adminMapper.projectSelectAll()).hasSize(1); }

//    @Test
//    public void projectSelectAllTest() {
//        adminMapper.projectSelectAll().stream().map(ProjectAdminDTO::toString).forEach(log::info);
//    }

    //    프로젝트 삭제 테스트
    @Test
    public void projectDeleteTest() { adminMapper.projectDelete(1L);}

    /* ------------------------------------------------------------------------------------ */

    //    문의사항 목록 테스트
    @Test
    public void inquirySelectAllTest() {
        assertThat(adminMapper.inquirySelectAll()).hasSize(1);
    }

    //    문의사항 답변 등록 테스트
    @Test
    public void answerInsertTest() {
        AnswerVO answerVO = new AnswerVO();
        answerVO.setAnswerContent("답변 내용");
        answerVO.setInquiryId(1L);
        adminMapper.answerInsert(answerVO);
    }

    //    문의사항 상세 테스트
    @Test
    public void inquirySelectTest() {
        adminMapper.inquirySelect(1L).map(InquiryAdminDTO::getInquiryTitle).ifPresent(log::info);
    }

    //    문의사항 답변 상세 테스트
    @Test
    public void answerSelectTest() {
        adminMapper.answerSelect(5L).map(AnswerVO::getAnswerContent).ifPresent(log::info);
    }

    //    문의사항 답변 수정 테스트
    @Test
    public void inquiryAnswerUpdateTest() {
        adminMapper.answerSelect(1L).ifPresent(answerVO -> {
            answerVO.setAnswerContent("문의 답변 수정 입니다");
            adminMapper.answerUpdate(answerVO);
        });
    }

    //    문의사항 답변 삭제 테스트
    @Test
    public void answerDeleteTest() {
        adminMapper.answerDelete(2L);
    }

    /* ------------------------------------------------------------------------------------ */

    //    회원 목록 테스트
    @Test
    public void memberSelectAllTest() { assertThat(adminMapper.memberSelectAll()).hasSize(2); }

    //    회원 삭제 테스트
    @Test
    public void memberDeleteTest() { adminMapper.memberDelete(2L);}

    /* ------------------------------------------------------------------------------------ */

    //    강연 목록 테스트
    @Test
    public void lectureSelectAllTest() { assertThat(adminMapper.lectureSelectAll()).hasSize(3); }

    //    강연 삭제 테스트

    @Test
    public void lectureDeleteTest() { adminMapper.lectureDelete(2L);}

    /* ------------------------------------------------------------------------------------ */
}
