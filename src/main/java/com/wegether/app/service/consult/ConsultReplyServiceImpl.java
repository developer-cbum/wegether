package com.wegether.app.service.consult;

import com.wegether.app.dao.ConsultingReplyDAO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultReplyServiceImpl implements ConsultReplyService {

    private final ConsultingReplyDAO consultingReplyDAO;

    //댓글 등록
    @Override
    public void registerReply(ConsultReplyDTO consultReplyDTO) {
        consultingReplyDAO.saveReply(consultReplyDTO);
    }

    //대댓글 등록
    @Override
    public void registerReplyAgain(ConsultReplyDTO consultReplyDTO) {
        consultingReplyDAO.saveReplyAgain(consultReplyDTO);
    }

    //일반 댓글 페이징처리 조회
    public List<ConsultReplyDTO> getList(Long consultingId, LecturePagination lecturePagination){
        return consultingReplyDAO.findAll(consultingId, lecturePagination);
    }

    //일반 댓글 총개수
    @Override
    public int getTotal(Long consultingId) {
        return consultingReplyDAO.findCountOfReply(consultingId);
    }

    //대댓글 리스트
    @Override
    public List<ConsultReplyDTO> getListAgain(Long consultingId) {
        return consultingReplyDAO.findAllAgain(consultingId);
    }


    //대댓글 총개수
    @Override
    public int getTotalAgain(Long consultingId, Long replyGroup) {
        return getTotalAgain(consultingId, replyGroup);
    }

    // 중간 테이블 삽입
    public void registerMiddle(Long id, Long memberId, Long consultingId){
        consultingReplyDAO.saveMiddle(id,memberId,consultingId);
    }

    //댓글 대댓글 삭제
    @Override
    public void removeReply(Long id) {
        consultingReplyDAO.deleteReply(id);
    }
    // 대댓글 전체삭제
    @Override
    public void removeReplyAgainAll(Long replyGroup) {
        consultingReplyDAO.deleteReplyAgainAll(replyGroup);
    }
    // 중간테이블 삭제
    @Override
    public void removeMiddle(Long id) {
        consultingReplyDAO.deleteMiddle(id);
    }

    //원하는 댓글 조회
    @Override
    public Optional<ConsultReplyDTO> get(Long id) {
        return consultingReplyDAO.find(id);
    }

    //대댓글들 조회
    @Override
    public List<ConsultReplyDTO> getAgain(Long replyGroup) {
       return consultingReplyDAO.findAgain(replyGroup);
    }
}
