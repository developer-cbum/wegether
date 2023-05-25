package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.vo.CommunityReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommunityReplyMapper {

//    ----------------------  INSERT ---------------------------------
    // 댓글 등록
    public void insert(CommunityReplyDTO communityReplyDTO);

    // 대댓글 등록
    public void insertDepth(CommunityReplyDTO communityReplyDTO);

    // 중간 테이블 삽입
    public void insertMiddle(CommunityReplyVO communityReplyVO);

//    ---------------------  SELECT --------------------------------------

    //일반 댓글 전체 조회
    public List<CommunityReplyDTO> selectAll(@Param("communityId") Long communityId, @Param("communityPagination") CommunityPagination communityPagination);

    // 대댓글 전체조회
    public List<CommunityReplyDTO> selectAllAgain(Long communityId);

    // 중간테이블 조회
    public Optional<CommunityReplyVO> selectMiddle(Long id);

    // 원하는 댓글 조회
    public Optional<CommunityReplyDTO> select(Long id);

    // 원하는 댓글 포함 대댓글 조회
    public List<CommunityReplyDTO> selectAgain(Long replyGroup);

//    그해당 하는 게시글에 중간테이블 전체 조회
    public List<CommunityReplyVO> selectMiddleAll(Long communityId);

//   일반댓글 대댓글 총개수
    public int selectCountOfReply(Long communityId);

//   일반댓글 총개수
    public int selectCount(Long communityId);

//   대댓글 총개수
    public int selectCountOfReplyAgain(Long communityId, Long replyGroup);

//    ------------------------------   UPDATE  -------------------------------------

//    댓글 수정
    public void update(CommunityReplyDTO communityReplyDTO);

//    -------------------------------- DELETE  -------------------------------------

//    일반댓글, 대댓글 삭제
    public void delete(Long id);

//  전체 삭제
    public void deleteAll(Long communityId);

//    대댓글 전체 삭제
    public void deleteReplyAgain(Long replyGroup);

//    중간테이블 삭제
    public void deleteMiddle(Long id);
}
