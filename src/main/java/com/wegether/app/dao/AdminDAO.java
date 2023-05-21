package com.wegether.app.dao;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
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
    public List<NoticeVO> noticeFindAll(){
        return adminMapper.noticeSelectAll();
    };

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
    public List<ProjectVO> projectFindAll(){
        return adminMapper.projectSelectAll();
    };

    // 프로젝트 삭제
    public void projectDelete(Long id){ adminMapper.projectDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    public List<ProjectVO> inquiryFindAll(){
        return adminMapper.inquirySelectAll();
    };

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
    public List<MemberVO> memberFindAll(){
        return adminMapper.memberSelectAll();
    };

    // 회원 삭제
    public void memberDelete(Long id) { adminMapper.memberDelete(id); };

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    public List<LectureVO> lectureFindAll() { return adminMapper.lectureSelectAll(); }

    // 강연 삭제
    public void lectureDelete(Long id) { adminMapper.lectureDelete(id); }

    /* --------------------------------------------------------------------------------- */
}
