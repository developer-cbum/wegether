package com.wegether.app.dao;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;
import com.wegether.app.mapper.ConsultingReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConsultingReplyDAO {

    private final ConsultingReplyMapper consultingReplyMapper;

    //댓글 등록
    public void saveReply(ConsultReplyDTO consultReplyDTO){
        consultingReplyMapper.insertReply(consultReplyDTO);
    }

    //대댓글 등록
    public void saveReplyAgain(ConsultReplyDTO consultReplyDTO){
        consultingReplyMapper.insertReplyAgain(consultReplyDTO);
    }

    //일반 댓글 페이징처리 조회
    public List<ConsultReplyDTO> findAll(Long consultingId, LecturePagination lecturePagination){
       return consultingReplyMapper.selectAll(consultingId, lecturePagination);
    }

    //일반 댓글 총개수
    public int findCountOfReply(Long consultingId){
        return consultingReplyMapper.selectCountOfReply(consultingId);
    }

    // 중간 테이블 삽입
    public void saveMiddle(Long id, Long memberId, Long consultingId){
        consultingReplyMapper.insertMiddle(id,memberId,consultingId);
    }


}
