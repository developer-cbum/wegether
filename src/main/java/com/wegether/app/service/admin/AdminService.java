package com.wegether.app.service.admin;

import com.wegether.app.domain.vo.NoticeVO;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    // 공지사항 목록
    public List<NoticeVO> noticeGetList();

    // 공지사항 등록
    public void noticeWrite(NoticeVO noticeVO);

    // 공지사항 상세
    public Optional<NoticeVO> noticeRead(Long id);

    // 공지사항 수정
    public void noticeModify(NoticeVO noticeVO);

    // 공지사항 삭제
    public void noticeRemove(Long id);
}




















