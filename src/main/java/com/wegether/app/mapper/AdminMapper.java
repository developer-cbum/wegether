package com.wegether.app.mapper;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {

    /* --------------------------------------------------------------------------------- */

    // 공지사항 목록
//    public List<NoticeVO> noticeSelectAll();
    public List<NoticeVO> noticeSelectAll(AdminPagination adminPagination);

    // 공지사항 총 갯수
    public int selectCountOfNotice();

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

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectAdminDTO> projectSelectAll(AdminPagination adminPagination);
//    public List<ProjectAdminDTO> projectSelectAll();

    // 프로젝트 총 갯수
    public int selectCountOfProject();

    // 프로젝트 삭제
    public void projectDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
//    public List<InquiryAdminDTO> inquirySelectAll();
    public List<InquiryAdminDTO> inquirySelectAll(AdminPagination adminPagination);

    // 문의사항 총 갯수
    public int selectCountOfInquiry();

    // 문의사항 상세
    public Optional<InquiryAdminDTO> inquirySelect(Long id);

    // 문의사항 답변 등록
    public void answerInsert(AnswerVO answerVO);

    // 문의사항 답변 여부
    public void inquiryUpdate(Long inquiryId);

    // 문의사항 답변 상세
    public Optional<AnswerAdminDTO> answerSelect(Long inquiryId);

    // 문의사항 수정 상세
    public Optional<AnswerAdminDTO> answerModifySelect(Long id);

    // 문의사항 답변 수정
    public void answerUpdate(AnswerAdminDTO answerAdminDTO);

    // 문의사항 답변 삭제
    public void answerDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    public List<MemberVO> memberSelectAll(AdminPagination adminPagination);

    // 회원 총 인원 수
    public int selectCountOfMember();

    // 회원 삭제
    public void memberDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureSelectAll(AdminPagination adminPagination);
//    public List<LectureVO> lectureSelectAll();

    // 강연 총 갯수
    public int selectCountOfLecture();

    // 강연 삭제
    public void lectureDelete(Long id);


}