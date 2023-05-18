package com.wegether.app.dao.admin;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class adminDAOTests {

    @Autowired
    private AdminDAO adminDAO;

    //    공지사항 목록 테스트
    @Test
    public void noticeFindAllTest() {
        assertThat(adminDAO.noticeFindAll()).hasSize(2);
    }

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

}
