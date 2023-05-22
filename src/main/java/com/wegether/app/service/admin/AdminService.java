package com.wegether.app.service.admin;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.dto.ProjectAdminDTO;
import com.wegether.app.domain.vo.*;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    /* --------------------------------------------------------------------------------- */
    
    // 공지사항 목록
//    public List<NoticeVO> noticeGetList();
    public List<NoticeVO> noticeGetList(AdminPagination adminPagination);

    // 공지사항 총 갯수
    public int getNoticeTotal();

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
    public List<DataAdminDTO> dataGetList(AdminPagination adminPagination);

    // 자료 총 갯수
    public int getDataTotal();

    // 자료 삭제
    public void dataRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectAdminDTO> projectGetList(AdminPagination adminPagination);
//    public List<ProjectAdminDTO> projectGetList();

    // 프로젝트 총 갯수
    public int getProjectTotal();

    // 프로젝트 삭제
    public void projectRemove(Long id);


    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
//    public List<InquiryAdminDTO> inquiryGetList();
    public List<InquiryAdminDTO> inquiryGetList(AdminPagination adminPagination);

    // 문의사항 총 갯수
    public int getInquiryTotal();

    // 문의사항 답변 등록
    public void answerWrite(AnswerVO answerVO);

    // 문의사항 상세
    public Optional<InquiryAdminDTO> inquiryRead(Long id);

    // 문의사항 답변 상세
    public Optional<AnswerVO> answerRead(Long inquiryId);

    // 문의사항 답변 수정
    public void answerModify(AnswerVO answerVO);

    // 문의사항 답변 삭제
    public void answerRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
//    public List<MemberVO> memberGetList();
    public List<MemberVO> memberGetList(AdminPagination adminPagination);

    // 회원 총 인원수
    public int getMemberTotal();

    // 회원 삭제
    public void memberRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
//    public List<LectureVO> lectureGetList();
    public List<LectureVO> lectureGetList(AdminPagination adminPagination);

    // 강연 총 갯수
    public int getLectureTotal();

    // 강연 삭제
    public void lectureRemove(Long id);

    /* --------------------------------------------------------------------------------- */
}




















