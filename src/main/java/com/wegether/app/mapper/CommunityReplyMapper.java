package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.vo.CommunityReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityReplyMapper {
    // 댓글 등록
    public void insert(CommunityReplyDTO communityReplyDTO);
    // 대댓글 등록
    public void insertDepth(CommunityReplyDTO communityReplyDTO);

    //일반 댓글 페이징처리 조회
    public List<CommunityReplyDTO> selectAll(@Param("communityId") Long communityId, @Param("communityPagination") CommunityPagination communityPagination);

//    대댓글 조회
    public List<CommunityReplyDTO> selectAllAgain(Long communityId);

    //일반 댓글 총개수
    public int selectCountOfReply(Long communityId);


    // 중간 테이블 삽입
    public void insertMiddle(CommunityReplyVO communityReplyVO);

//    댓글 수정
    public void update(CommunityReplyDTO communityReplyDTO);

//    댓글 삭제
    public void delete(Long id);

//  전체 삭제
    public void deleteAll(Long communityId);
}
