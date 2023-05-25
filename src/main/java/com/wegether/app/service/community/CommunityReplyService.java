package com.wegether.app.service.community;


import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.vo.CommunityReplyVO;

import java.util.List;
import java.util.Optional;

public interface CommunityReplyService {

//   --------------------------- INSERT --------------------------------------------

    // 댓글등록
    public void register(CommunityReplyDTO communityReplyDTO);

    // 대댓글 등록
    public void registerDepth(CommunityReplyDTO communityReplyDTO);

    // 중간 테이블 등록
    public void registerMiddle(CommunityReplyVO communityReplyVO);

// ---------------------------- SELECT -------------------------------------------------

    //일반 댓글 전체 조회
    public List<CommunityReplyDTO> getList(Long communityId, CommunityPagination communityPagination);

    // 대댓글 전체 조회
    public List<CommunityReplyDTO> getListAgain(Long communityId);

    // 중간테이블 조회
    public Optional<CommunityReplyVO> getMiddle(Long id);

    // 원하는 댓글 조회
    public Optional<CommunityReplyDTO> getReply(Long id);

    // 원하는 댓글 포함 대댓글 조회
    public List<CommunityReplyDTO> getAgain(Long replyGroup);

    // 그 해당하는 게시글에 중간테이블 전체 조회
    public List<CommunityReplyVO> getMiddleList(Long communityId);

    // 일반댓글 대댓글 총개수
    public int getTotalOfReply(Long id);

    //일반 댓글 총개수
    public int getTotal(Long communityId);

    // 대댓글 총개수
    public int getTotalOfReplyAgain(Long id, Long replyGroup);


// ------------------------------ UPDATE -------------------------------------

    // 댓글 수정
    public void modify(CommunityReplyDTO communityReplyDTO);

// ------------------------------ DELETE ---------------------------------------

    // 일반댓글, 대댓글 삭제
    public void remove(Long id);

    //댓글 전체 삭제
     public void removeAll(Long communityId);

    // 대댓글 전체 삭제
    public void removeReplyAgain(Long replyGroup);

    // 중간테이블 삭제
    public void removeMiddle(Long id);
}
