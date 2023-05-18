package com.wegether.app.service.admin;

import com.wegether.app.dao.AdminDAO;
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

}
