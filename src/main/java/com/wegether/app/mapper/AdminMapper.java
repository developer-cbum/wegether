package com.wegether.app.mapper;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {

    /* --------------------------------------------------------------------------------- */

    // 공지사항 목록
    public List<NoticeAdminDTO> noticeSelectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);

    // 공지사항 목록(이미지)
    public List<NoticeFileAdminDTO> noticeImageSelectAll(Long noticeId);

    // 공지사항 총 갯수
    public int selectCountOfNotice(@Param("search") Search search);

    // 공지사항 등록
//    public void noticeInsert(NoticeVO noticeVO);

    // 공지사항 등록(첨부파일)
    public void noticeInsert(NoticeAdminDTO noticeAdminDTO);

    // 공지사항 이미지 등록
    public void noticeImageInsert(NoticeFileAdminDTO noticeFileAdminDTO);

    // 공지사항 이미지 등록(중간 테이블)
    public void noticeImageMiddleInsert(NoticeFileVO noticeFileVO);

    // 공지사항 상세
    public Optional<NoticeAdminDTO> noticeSelect(Long id);

    // 공지사항 수정
    public void noticeUpdate(NoticeAdminDTO noticeAdminDTO);

    // 공지사항 삭제
    public void noticeDelete(Long id);

    // 파일 삭제
    public void fileDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    public List<DataAdminDTO> dataSelectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);

    // 자료 총 갯수
    public int selectCountOfData(@Param("search") Search search);

    // 자료 삭제
    public void dataDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectAdminDTO> projectSelectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);

    // 프로젝트 총 갯수
    public int selectCountOfProject(@Param("search") Search search);

    // 프로젝트 삭제
    public void projectDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    public List<InquiryAdminDTO> inquirySelectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);

    // 문의사항 총 갯수
    public int selectCountOfInquiry(@Param("search") Search search);

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
    public List<MemberVO> memberSelectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);

    // 회원 총 인원 수
    public int selectCountOfMember(@Param("search") Search search);

    // 회원 삭제
    public void memberDelete(Long id);

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureSelectAll(@Param("adminPagination") AdminPagination adminPagination, @Param("search")Search search);

    // 강연 총 갯수
    public int selectCountOfLecture(@Param("search") Search search);

    // 강연 삭제
    public void lectureDelete(Long id);


}