package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConsultingReplyMapper {


    // 댓글 등록
    public void insertReply(ConsultReplyDTO consultReplyDTO);
    // 대댓글 등록
    public void insertReplyAgain(ConsultReplyDTO consultReplyDTO);

    //일반 댓글 페이징처리 조회
    public List<ConsultReplyDTO> selectAll(@Param("consultingId") Long consultingId, @Param("lecturePagination") LecturePagination lecturePagination);

    //일반 댓글 총개수
    public int selectCountOfReply(Long consultingId);

    // 대댓글 전체 조회
    public List<ConsultReplyDTO> selectAllAgain(Long consultingId);

    // 대댓글 전체 개수
    public int selectCountOfReplyAgain(Long consultingId, Long replyGroup);


    // 중간 테이블 삽입
    public void insertMiddle(Long id, Long memberId, Long consultingId);

}
