package com.wegether.app.dao;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.*;
import com.wegether.app.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    /* --------------------------------------------------------------------------------- */

    // 공지사항 목록
    public List<NoticeAdminDTO> noticeFindAll(AdminPagination adminPagination, Search search){
        return adminMapper.noticeSelectAll(adminPagination, search);
    };

    // 공지사항 목록(이미지)
    public List<NoticeFileAdminDTO> noticeImageFindAll(Long noticeId){
        return adminMapper.noticeImageSelectAll(noticeId);
    };

    // 공지사항 총 갯수
    public int findCountOfNotice(Search search) { return adminMapper.selectCountOfNotice(search); }

//    // 공지사항 등록
//    public void noticeSave(NoticeVO noticeVO){ adminMapper.noticeInsert(noticeVO); };

    // 공지사항 등록(첨부파일)
    public void noticeSave(NoticeAdminDTO noticeAdminDTO){ adminMapper.noticeInsert(noticeAdminDTO); };

    // 공지사항 이미지 등록
    public void noticeImageSave(NoticeFileAdminDTO noticeFileAdminDTO) { adminMapper.noticeImageInsert(noticeFileAdminDTO);}

    // 공지사항 이미지 등록(중간 테이블)
    public void noticeImageMiddleSave(NoticeFileVO noticeFileVO) { adminMapper.noticeImageMiddleInsert(noticeFileVO);}

    // 공지사항 상세
    public Optional<NoticeAdminDTO> noticeFindById(Long id){ return adminMapper.noticeSelect(id); };

    // 공지사항 수정
    public void setNoticeVO(NoticeVO noticeVO){ adminMapper.noticeUpdate(noticeVO); };

    // 공지사항 삭제
    public void noticeDelete(Long id){ adminMapper.noticeDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    public List<DataAdminDTO> dataFindAll(AdminPagination adminPagination, Search search){
        return adminMapper.dataSelectAll(adminPagination, search);
    };

    // 자료 총 갯수
    public int findCountOfData(Search search) { return adminMapper.selectCountOfData(search); }

    // 자료 삭제
    public void dataDelete(Long id){ adminMapper.dataDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectAdminDTO> projectFindAll(AdminPagination adminPagination, Search search){
        return adminMapper.projectSelectAll(adminPagination, search);
    };

    // 프로젝트 총 갯수
    public int findCountOfProject(Search search) { return adminMapper.selectCountOfProject(search); }

    // 프로젝트 삭제
    public void projectDelete(Long id){ adminMapper.projectDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    public List<InquiryAdminDTO> inquiryFindAll(AdminPagination adminPagination, Search search){
        return adminMapper.inquirySelectAll(adminPagination, search);
    };

    // 문의사항 총 갯수
    public int findCountOfInquiry(Search search) { return adminMapper.selectCountOfInquiry(search); }

    // 문의사항 상세
    public Optional<InquiryAdminDTO> inquiryFindById(Long id){ return adminMapper.inquirySelect(id); };

    // 문의사항 답변 등록
    public void answerSave(AnswerVO answerVO){ adminMapper.answerInsert(answerVO); };

    // 문의사항 답변 여부
    public void setInquiryStatus(Long inquiryId) { adminMapper.inquiryUpdate(inquiryId); }

    // 문의사항 답변 상세
    public Optional<AnswerAdminDTO> answerFindById(Long inquiryId){
        return adminMapper.answerSelect(inquiryId);
    };

    // 문의사항 수정 상세
    public Optional<AnswerAdminDTO> answerModifyFindById(Long id){
        return adminMapper.answerModifySelect(id);
    };

    // 문의사항 답변 수정
    public void setAnswerVO(AnswerAdminDTO answerAdminDTO){
        adminMapper.answerUpdate(answerAdminDTO);
    };

    // 문의사항 답변 삭제
    public void answerDelete(Long id){
        adminMapper.answerDelete(id);
    };

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    public List<MemberVO> memberFindAll(AdminPagination adminPagination, Search search){
        return adminMapper.memberSelectAll(adminPagination, search);
    };

    // 회원 총 인원 수
    public int findCountOfMember(Search search) { return adminMapper.selectCountOfMember(search); }

    // 회원 삭제
    public void memberDelete(Long id) { adminMapper.memberDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureFindAll(AdminPagination adminPagination, Search search){
        return adminMapper.lectureSelectAll(adminPagination, search);
    };

    // 강연 총 갯수
    public int findCountOfLecture(Search search) { return adminMapper.selectCountOfLecture(search); }

    // 강연 삭제
    public void lectureDelete(Long id) { adminMapper.lectureDelete(id); }

    /* --------------------------------------------------------------------------------- */
}
