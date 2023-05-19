package com.wegether.app.service.admin;

import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.domain.vo.ProjectVO;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    /* --------------------------------------------------------------------------------- */
    
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

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    public List<DataAdminDTO> dataGetList();

    // 자료 삭제
    public void dataRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectVO> projectGetList();

    // 프로젝트 삭제
    public void projectRemove(Long id);
}




















