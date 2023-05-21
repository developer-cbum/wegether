package com.wegether.app.mapper;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {

    /* --------------------------------------------------------------------------------- */

    // 공지사항 목록
    public List<NoticeVO> noticeSelectAll();

    // 공지사항 등록
    public void noticeInsert(NoticeVO noticeVO);

    // 공지사항 상세
    public Optional<NoticeVO> noticeSelect(Long id);

    // 공지사항 수정
    public void noticeUpdate(NoticeVO noticeVO);

    // 공지사항 삭제
    public void noticeDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    public List<DataAdminDTO> dataSelectAll(AdminPagination adminPagination);

    // 자료 총 갯수
    public int selectCountOfData();

    // 자료 삭제
    public void dataDelete(Long id);

    // 자료 선택 삭제(작업 필요)

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectVO> projectSelectAll();

    // 프로젝트 삭제
    public void projectDelete(Long id);

    // 자료 선택 삭제(작업 필요)
    
    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    public List<ProjectVO> inquirySelectAll();

    // 문의사항 답변 등록
    public void answerInsert(AnswerVO answerVO);

    // 문의사항 상세
    public Optional<InquiryAdminDTO> inquirySelect(Long id);

    // 문의사항 답변 상세
    public Optional<AnswerVO> answerSelect(Long inquiryId);

    // 문의사항 답변 수정
    public void answerUpdate(AnswerVO answerVO);

    // 문의사항 답변 삭제
    public void answerDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    public List<MemberVO> memberSelectAll();

    // 회원 삭제
    public void memberDelete(Long id);

    // 회원 선택 삭제(작업 필요)

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureSelectAll();

    // 강연 삭제
    public void lectureDelete(Long id);


}