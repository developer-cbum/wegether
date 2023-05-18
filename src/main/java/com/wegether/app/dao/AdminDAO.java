package com.wegether.app.dao;

import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    // 공지사항 목록
    public List<NoticeVO> noticeFindAll(){
        return adminMapper.noticeSelectAll();
    };

    // 공지사항 등록
    public void noticeSave(NoticeVO noticeVO){ adminMapper.noticeInsert(noticeVO); };

    // 공지사항 상세
    public Optional<NoticeVO> noticeFindById(Long id){ return adminMapper.noticeSelect(id); };

    // 공지사항 수정
    public void setNoticeVO(NoticeVO noticeVO){ adminMapper.noticeUpdate(noticeVO); };

    // 공지사항 삭제
    public void noticeDelete(Long id){ adminMapper.noticeDelete(id); };

}
