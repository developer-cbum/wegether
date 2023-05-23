package com.wegether.app.dao;

import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.mapper.CommunityReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommunityReplyDAO {

    private final CommunityReplyMapper communityReplyMapper;

    //댓글 등록
    public void save(CommunityReplyDTO communityReplyDTO){
        communityReplyMapper.insert(communityReplyDTO);
    }

    //대댓글 등록
    public void saveDepth(CommunityReplyDTO communityReplyDTO){
        communityReplyMapper.insertDepth(communityReplyDTO);
    }

    //일반 댓글 페이징처리 조회
    public List<CommunityReplyDTO> findAll(Long communityId, CommunityPagination communityPagination){
        return communityReplyMapper.selectAll(communityId, communityPagination);
    }

    //일반 댓글 총개수
    public int findCountOfReply(Long communityId){
        return communityReplyMapper.selectCountOfReply(communityId);
    }

    // 중간 테이블 삽입
    public void saveMiddle(Long id, Long memberId, Long communityId){
        communityReplyMapper.insertMiddle(id, memberId, communityId);
    }

//   댓글 수정
    public void setCommunityReplyDTO(CommunityReplyDTO communityReplyDTO){
        communityReplyMapper.update(communityReplyDTO);
    }

//    댓글 삭제
    public void delete(Long id){
        communityReplyMapper.delete(id);
    }

//    댓글 전체 삭제
    public void deleteAll(Long communityId){
        communityReplyMapper.deleteAll(communityId);
    }


}
