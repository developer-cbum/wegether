package com.wegether.app.service.consult;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;

import java.util.List;

public interface
ConsultReplyService {

    // 댓글등록
    public void registerReply(ConsultReplyDTO consultReplyDTO);

    // 대댓글 등록
    public void registerReplyAgain(ConsultReplyDTO consultReplyDTO);

    //일반 댓글 페이징처리 조회
    public List<ConsultReplyDTO> getList(Long consultingId, LecturePagination lecturePagination);

    //일반 댓글 총개수
    public int getTotal(Long consultingId);

    // 중간 테이블 삽입
    public void registerMiddle(Long id, Long memberId, Long consultingId);

}
