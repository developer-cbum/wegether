package com.wegether.app.service.admin;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.DataAdminDTO;
import com.wegether.app.domain.dto.InquiryAdminDTO;
import com.wegether.app.domain.dto.ProjectAdminDTO;
import com.wegether.app.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;

    /* --------------------------------------------------------------------------------- */

    // 공지사항 목록
    @Override
//    public List<NoticeVO> noticeGetList() { return adminDAO.noticeFindAll(); }
    public List<NoticeVO> noticeGetList(AdminPagination adminPagination) {
        return adminDAO.noticeFindAll(adminPagination);
    }

    // 공지사항 총 갯수
    @Override
    public int getNoticeTotal() { return adminDAO.FindCountOfNotice(); }

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

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    @Override
    public List<DataAdminDTO> dataGetList(AdminPagination adminPagination) { return adminDAO.dataFindAll(adminPagination); }

    // 자료 총 갯수
    @Override
    public int getDataTotal() { return adminDAO.FindCountOfData(); }

    // 자료 삭제
    @Override
    public void dataRemove(Long id) { adminDAO.dataDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    @Override
    public List<ProjectAdminDTO> projectGetList(AdminPagination adminPagination) {
        return adminDAO.projectFindAll(adminPagination);
//    public List<ProjectAdminDTO> projectGetList() {
//        return adminDAO.projectFindAll();
    }

    // 프로젝트 총 갯수
    @Override
    public int getProjectTotal() { return adminDAO.FindCountOfProject(); }

    // 프로젝트 삭제
    @Override
    public void projectRemove(Long id) { adminDAO.projectDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    @Override
//    public List<InquiryAdminDTO> inquiryGetList() {
//        return adminDAO.inquiryFindAll();
//    }

    public List<InquiryAdminDTO> inquiryGetList(AdminPagination adminPagination) {
        return adminDAO.inquiryFindAll(adminPagination);
    }

    // 문의사항 총 갯수
    @Override
    public int getInquiryTotal() { return adminDAO.FindCountOfInquiry(); }

    // 문의사항 답변 등록
    @Override
    public void answerWrite(AnswerVO answerVO) {
        adminDAO.answerSave(answerVO);
    }

    // 문의사항 상세
    @Override
    public Optional<InquiryAdminDTO> inquiryRead(Long id) {
        return adminDAO.inquiryFindById(id);
    }

    // 문의사항 답변 상세
    @Override
    public Optional<AnswerVO> answerRead(Long inquiryId) {
        return adminDAO.answerFindById(inquiryId);
    }

    // 문의사항 답변 수정
    @Override
    public void answerModify(AnswerVO answerVO) {
        adminDAO.setAnswerVO(answerVO);
    }

    // 문의사항 답변 삭제
    @Override
    public void answerRemove(Long id) {
        adminDAO.answerDelete(id);
    }

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    @Override
//    public List<MemberVO> memberGetList() { return adminDAO.memberFindAll(); }
    public List<MemberVO> memberGetList(AdminPagination adminPagination) {
        return adminDAO.memberFindAll(adminPagination);
    }

    // 회원 총 인원 수
    @Override
    public int getMemberTotal() { return adminDAO.findCountOfMember(); }

    // 회원 삭제
    @Override
    public void memberRemove(Long id) { adminDAO.memberDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    @Override
//    public List<LectureVO> lectureGetList() { return adminDAO.lectureFindAll(); }
    public List<LectureVO> lectureGetList(AdminPagination adminPagination) {
        return adminDAO.lectureFindAll(adminPagination);
    }

    // 강연 총 갯수
    @Override
    public int getLectureTotal() { return adminDAO.findCountOfLecture(); }

    // 강연 삭제
    @Override
    public void lectureRemove(Long id) { adminDAO.lectureDelete(id); }
}
