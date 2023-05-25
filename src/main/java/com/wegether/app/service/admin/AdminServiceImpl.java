package com.wegether.app.service.admin;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;

    /* --------------------------------------------------------------------------------- */

    // 공지사항 목록
    @Override
    public List<NoticeAdminDTO> noticeGetList(AdminPagination adminPagination, Search search) {
        // 공지사항 전체 목록
        final List<NoticeAdminDTO> notices = adminDAO.noticeFindAll(adminPagination, search);
        // 공지사항 하나씩 첨부파일 목록 담기
        notices.forEach(notice -> notice.setFiles(adminDAO.noticeImageFindAll(notice.getId())));
        return notices;
    }

    // 공지사항 목록(이미지)
    @Override
    public List<NoticeFileAdminDTO> noticeImageGetList(Long noticeId) {
        return adminDAO.noticeImageFindAll(noticeId);
    }

    // 공지사항 총 갯수
    @Override
    public int getNoticeTotal(Search search) { return adminDAO.findCountOfNotice(search); }

    // 공지사항 등록
//    @Override
//    public void noticeWrite(NoticeVO noticeVO) { adminDAO.noticeSave(noticeVO); }

    // 공지사항 등록(첨부파일)
    @Override
    public void noticeWrite(NoticeAdminDTO noticeAdminDTO) { adminDAO.noticeSave(noticeAdminDTO); }

    // 공지사항 이미지 등록
    @Override
    public void noticeImageWrite(NoticeFileAdminDTO noticeFileAdminDTO) { adminDAO.noticeImageSave(noticeFileAdminDTO); }

    // 공지사항 이미지 등록(중간 테이블)
    @Override
    public void noticeImageMiddleWrite(NoticeFileVO noticeFileVO) { adminDAO.noticeImageMiddleSave(noticeFileVO); }

    // 공지사항 상세
    @Override
    public Optional<NoticeAdminDTO> noticeRead(Long id) {
        final Optional<NoticeAdminDTO> foundNoticeDetail = adminDAO.noticeFindById(id);
        if(foundNoticeDetail.isPresent()){
            foundNoticeDetail.get().setFiles(adminDAO.noticeImageFindAll(foundNoticeDetail.get().getId()));
        }
        return foundNoticeDetail;
    }

    // 공지사항 수정
    @Override
    public void noticeModify(NoticeVO noticeVO) { adminDAO.setNoticeVO(noticeVO); }

    // 공지사항 삭제
    @Override
    public void noticeRemove(Long id) { adminDAO.noticeDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 자료 목록
    @Override
    public List<DataAdminDTO> dataGetList(AdminPagination adminPagination, Search search) {
        return adminDAO.dataFindAll(adminPagination, search);
    }

    // 자료 총 갯수
    @Override
    public int getDataTotal(Search search) { return adminDAO.findCountOfData(search); }

    // 자료 삭제
    @Override
    public void dataRemove(Long id) { adminDAO.dataDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 프로젝트 목록
    @Override
    public List<ProjectAdminDTO> projectGetList(AdminPagination adminPagination, Search search) {
        return adminDAO.projectFindAll(adminPagination, search);
    }

    // 프로젝트 총 갯수
    @Override
    public int getProjectTotal(Search search) { return adminDAO.findCountOfProject(search); }

    // 프로젝트 삭제
    @Override
    public void projectRemove(Long id) { adminDAO.projectDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 문의사항 목록
    @Override
    public List<InquiryAdminDTO> inquiryGetList(AdminPagination adminPagination, Search search) {
        return adminDAO.inquiryFindAll(adminPagination, search);
    }

    // 문의사항 총 갯수
    @Override
    public int getInquiryTotal(Search search) { return adminDAO.findCountOfInquiry(search); }

    // 문의사항 상세
    @Override
    public Optional<InquiryAdminDTO> inquiryRead(Long id) {
        return adminDAO.inquiryFindById(id);
    }

    // 문의사항 답변 등록
    @Override
    public void answerWrite(AnswerVO answerVO) {
        adminDAO.answerSave(answerVO);
    }

    // 문의사항 답변 여부
    @Override
    public void inquiryStatusChange(Long inquiryId) {
        adminDAO.setInquiryStatus(inquiryId);
    }

    // 문의사항 답변 상세
    @Override
    public Optional<AnswerAdminDTO> answerRead(Long inquiryId) {
        return adminDAO.answerFindById(inquiryId);
    }

    // 문의사항 수정 상세
    @Override
    public Optional<AnswerAdminDTO> answerModifyRead(Long id) {
        return adminDAO.answerModifyFindById(id);
    }

    // 문의사항 답변 수정
    @Override
    public void answerModify(AnswerAdminDTO answerAdminDTO) {
        adminDAO.setAnswerVO(answerAdminDTO);
    }

    // 문의사항 답변 삭제
    @Override
    public void answerRemove(Long id) {
        adminDAO.answerDelete(id);
    }

    /* --------------------------------------------------------------------------------- */

    // 회원 목록
    @Override
    public List<MemberVO> memberGetList(AdminPagination adminPagination, Search search) {
        return adminDAO.memberFindAll(adminPagination, search);
    }

    // 회원 총 인원 수
    @Override
    public int getMemberTotal(Search search) { return adminDAO.findCountOfMember(search); }

    // 회원 삭제
    @Override
    public void memberRemove(Long id) { adminDAO.memberDelete(id); }

    /* --------------------------------------------------------------------------------- */

    // 강연 목록
    @Override
    public List<LectureVO> lectureGetList(AdminPagination adminPagination, Search search) {
        return adminDAO.lectureFindAll(adminPagination, search);
    }

    // 강연 총 갯수
    @Override
    public int getLectureTotal(Search search) { return adminDAO.findCountOfLecture(search); }

    // 강연 삭제
    @Override
    public void lectureRemove(Long id) { adminDAO.lectureDelete(id); }
}
