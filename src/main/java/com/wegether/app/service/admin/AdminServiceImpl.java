package com.wegether.app.service.admin;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.domain.vo.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;

    // 공지사항 목록
    @Override
    public List<NoticeVO> noticeGetList() { return adminDAO.noticeFindAll(); }

    // 공지사항 등록
    @Override
    public void noticeWrite(NoticeVO noticeVO) { adminDAO.noticeSave(noticeVO); }

    // 공지사항 상세
    @Override
    public Optional<NoticeVO> noticeRead(Long id) { return adminDAO.noticeFindById(id); }

    // 공지사항 수정
    @Override
    public void noticeModify(NoticeVO noticeVO) { adminDAO.setNoticeVO(noticeVO); }

    // 공지사항 삭제
    @Override
    public void noticeRemove(Long id) { adminDAO.noticeDelete(id); }
}
