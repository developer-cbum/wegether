package com.wegether.app.mapper.admin;

import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
public class AdminMapperTests {

    @Autowired
    private AdminMapper adminMapper;

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
        adminMapper.noticeSelect(2L).map(NoticeVO::getNoticeTitle).ifPresent(log::info);
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

}
