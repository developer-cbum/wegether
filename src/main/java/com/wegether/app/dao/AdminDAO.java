package com.wegether.app.dao;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.dto.ProjectAdminDTO;
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
//    public List<NoticeVO> noticeFindAll(){
//        return adminMapper.noticeSelectAll();
//    };
    public List<NoticeVO> noticeFindAll(AdminPagination adminPagination){
        return adminMapper.noticeSelectAll(adminPagination);
    };

    // 공지사항 총 갯수
    public int FindCountOfNotice() { return adminMapper.selectCountOfNotice(); }

    // 공지사항 등록
    public void noticeSave(NoticeVO noticeVO){ adminMapper.noticeInsert(noticeVO); };

    // 공지사항 상세
    public Optional<NoticeVO> noticeFindById(Long id){ return adminMapper.noticeSelect(id); };

    // 공지사항 수정
    public void setNoticeVO(NoticeVO noticeVO){ adminMapper.noticeUpdate(noticeVO); };

    // 공지사항 삭제
    public void noticeDelete(Long id){ adminMapper.noticeDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    public List<DataAdminDTO> dataFindAll(AdminPagination adminPagination){
        return adminMapper.dataSelectAll(adminPagination);
    };

    // 자료 총 갯수
    public int FindCountOfData() { return adminMapper.selectCountOfData(); }

    // 자료 삭제
    public void dataDelete(Long id){ adminMapper.dataDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    public List<ProjectAdminDTO> projectFindAll(AdminPagination adminPagination){
        return adminMapper.projectSelectAll(adminPagination);
    };
//    public List<ProjectAdminDTO> projectFindAll(){
//        return adminMapper.projectSelectAll();
//    };

    // 프로젝트 총 갯수
    public int FindCountOfProject() { return adminMapper.selectCountOfProject(); }

    // 프로젝트 삭제
    public void projectDelete(Long id){ adminMapper.projectDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
//    public List<InquiryAdminDTO> inquiryFindAll(){
//        return adminMapper.inquirySelectAll();
//    };
    public List<InquiryAdminDTO> inquiryFindAll(AdminPagination adminPagination){
        return adminMapper.inquirySelectAll(adminPagination);
    };

    // 문의사항 총 갯수
    public int FindCountOfInquiry() { return adminMapper.selectCountOfInquiry(); }

    // 문의사항 답변 등록
    public void answerSave(AnswerVO answerVO){
        adminMapper.answerInsert(answerVO);
    };

    // 문의사항 상세
    public Optional<InquiryAdminDTO> inquiryFindById(Long id){
        return adminMapper.inquirySelect(id);
    };

    // 문의사항 답변 상세
    public Optional<AnswerVO> answerFindById(Long inquiryId){
        return adminMapper.answerSelect(inquiryId);
    };

    // 문의사항 답변 수정
    public void setAnswerVO(AnswerVO answerVO){
        adminMapper.answerUpdate(answerVO);
    };

    // 문의사항 답변 삭제
    public void answerDelete(Long id){
        adminMapper.answerDelete(id);
    };

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    public List<MemberVO> memberFindAll(AdminPagination adminPagination){
        return adminMapper.memberSelectAll(adminPagination);
    };

//    public List<MemberVO> memberFindAll(){
//        return adminMapper.memberSelectAll();
//    };

    // 회원 총 인원 수
    public int findCountOfMember() { return adminMapper.selectCountOfMember(); }

    // 회원 삭제
    public void memberDelete(Long id) { adminMapper.memberDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureFindAll(AdminPagination adminPagination){
        return adminMapper.lectureSelectAll(adminPagination);
    };

//    public List<LectureVO> lectureFindAll() { return adminMapper.lectureSelectAll(); }

    // 강연 총 갯수
    public int findCountOfLecture() { return adminMapper.selectCountOfLecture(); }

    // 강연 삭제
    public void lectureDelete(Long id) { adminMapper.lectureDelete(id); }

    /* --------------------------------------------------------------------------------- */
}
