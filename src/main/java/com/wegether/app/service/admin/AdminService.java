package com.wegether.app.service.admin;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.*;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    /* --------------------------------------------------------------------------------- */
    
    // 공지사항 목록
    public List<NoticeAdminDTO> noticeGetList(AdminPagination adminPagination, Search search);

    // 공지사항 총 갯수
    public int getNoticeTotal(Search search);

    // 공지사항 등록
    public void noticeWrite(NoticeVO noticeVO);

    // 공지사항 이미지 등록

    // 공지사항 이미지 등록(중간 테이블)
    public void noticeImageMiddleWrite(NoticeFileVO noticeFileVO);

    // 공지사항 상세
    public Optional<NoticeAdminDTO> noticeRead(Long id);

    // 공지사항 수정
    public void noticeModify(NoticeVO noticeVO);

    // 공지사항 삭제
    public void noticeRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    public List<DataAdminDTO> dataGetList(AdminPagination adminPagination, Search search);

    // 자료 총 갯수
    public int getDataTotal(Search search);

    // 자료 삭제
    public void dataRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectAdminDTO> projectGetList(AdminPagination adminPagination, Search search);
//    public List<ProjectAdminDTO> projectGetList();

    // 프로젝트 총 갯수
    public int getProjectTotal(Search search);

    // 프로젝트 삭제
    public void projectRemove(Long id);


    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    public List<InquiryAdminDTO> inquiryGetList(AdminPagination adminPagination, Search search);

    // 문의사항 총 갯수
    public int getInquiryTotal(Search search);

    // 문의사항 상세
    public Optional<InquiryAdminDTO> inquiryRead(Long id);

    // 문의사항 답변 등록
    public void answerWrite(AnswerVO answerVO);

    // 문의사항 답변 여부
    public void inquiryStatusChange(Long inquiryId);

    // 문의사항 답변 상세
    public Optional<AnswerAdminDTO> answerRead(Long inquiryId);

    // 문의사항 수정 상세
    public Optional<AnswerAdminDTO> answerModifyRead(Long id);

    // 문의사항 답변 수정
    public void answerModify(AnswerAdminDTO answerAdminDTO);

    // 문의사항 답변 삭제
    public void answerRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    public List<MemberVO> memberGetList(AdminPagination adminPagination, Search search);

    // 회원 총 인원수
    public int getMemberTotal(Search search);

    // 회원 삭제
    public void memberRemove(Long id);

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureGetList(AdminPagination adminPagination, Search search);

    // 강연 총 갯수
    public int getLectureTotal(Search search);

    // 강연 삭제
    public void lectureRemove(Long id);

    /* --------------------------------------------------------------------------------- */
}




















