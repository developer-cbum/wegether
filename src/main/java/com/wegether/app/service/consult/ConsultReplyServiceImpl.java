package com.wegether.app.service.consult;

import com.wegether.app.dao.ConsultingReplyDAO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // 중간 테이블 삽입
    public void registerMiddle(Long id, Long memberId, Long consultingId){
        consultingReplyDAO.saveMiddle(id,memberId,consultingId);
    }

    @Override
    public int getTotal(Long consultingId) {
        return consultingReplyDAO.findCountOfReply(consultingId);
    }
}
