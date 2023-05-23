package com.wegether.app.dao;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;
import com.wegether.app.domain.vo.ConsultingReplyVO;
import com.wegether.app.mapper.ConsultingReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    // 대댓글 전체 조회
    public List<ConsultReplyDTO> findAllAgain(Long consultingId){
        return consultingReplyMapper.selectAllAgain(consultingId);
    }

    // 대댓글 전체 개수
    public int findCountOfReplyAgain(Long consultingId, Long replyGroup){
        return consultingReplyMapper.selectCountOfReplyAgain(consultingId, replyGroup);
    }



    // 중간 테이블 삽입
    public void saveMiddle(Long id, Long memberId, Long consultingId){
        consultingReplyMapper.insertMiddle(id,memberId,consultingId);
    }

    //일반 댓글, 대댓글 삭제
    public void deleteReply(Long id){
        consultingReplyMapper.deleteReply(id);
    }

    //대댓글 전체삭제
    public void deleteReplyAgainAll(Long replyGroup){
        consultingReplyMapper.deleteReplyAgainAll(replyGroup);
    }

    //중간 테이블 조회
    public Optional<ConsultingReplyVO> findMiddle(Long id){
        return consultingReplyMapper.selectMiddle(id);
    }

    //중간 테이블 삭제
    public void deleteMiddle(Long id){
        consultingReplyMapper.deleteMiddle(id);
    }

    // 원하는 댓글 조회
    public Optional<ConsultReplyDTO> find(Long id){
        return consultingReplyMapper.select(id);
    }

    //  원하는  대댓글 조회
    public List<ConsultReplyDTO> findAgain(Long replyGroup){
       return consultingReplyMapper.selectAgain(replyGroup);
    }

    //그 게시글에 해당되는 모든 중간테이블 삭제
    public void deleteMiddleAll(Long consultingId){
        consultingReplyMapper.deleteMiddleAll(consultingId);
    }


    //    그 해당 하는 게시글에 중간테이블 전체 조회
    public List<ConsultingReplyVO> findMiddleAll(Long consultingId){
       return consultingReplyMapper.selectMiddleAll(consultingId);
    }


}
