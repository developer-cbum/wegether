package com.wegether.app.service.community;


import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;

import java.util.List;

public interface CommunityReplyService {

    // 댓글등록
    public void register(CommunityReplyDTO communityReplyDTO);

    // 대댓글 등록
    public void registerDepth(CommunityReplyDTO communityReplyDTO);

    //일반 댓글 페이징처리 조회
    public List<CommunityReplyDTO> getList(Long communityId, CommunityPagination communityPagination);

    // 대댓글 조회
    public List<CommunityReplyDTO> getListAgain(Long communityId);

    //일반 댓글 총개수
    public int getTotal(Long communityId);


    // 댓글 수정
    public void modify(CommunityReplyDTO communityReplyDTO);

    //댓글 삭제
    public void remove(Long id);

    //댓글 전체 삭제
     public void removeAll(Long communityId);
}
