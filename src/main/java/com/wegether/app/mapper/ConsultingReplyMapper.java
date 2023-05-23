package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.ReplyDTO;
import com.wegether.app.domain.vo.ConsultingReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

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


    //일반 댓글, 대댓글 삭제
    public void deleteReply(Long id);

    //대댓글 전체삭제
    public void deleteReplyAgainAll(Long replyGroup);

    //중간 테이블 조회
    public Optional<ConsultingReplyVO> selectMiddle(Long id);

    //중간 테이블 삭제
    public void deleteMiddle(Long id);

    // 원하는 댓글 조회
    public Optional<ConsultReplyDTO> select(Long id);

    //  원하는  대댓글 조회
    public List<ConsultReplyDTO> selectAgain();

}
