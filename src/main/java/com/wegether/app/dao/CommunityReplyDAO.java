package com.wegether.app.dao;

import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.vo.CommunityReplyVO;
import com.wegether.app.mapper.CommunityReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class    CommunityReplyDAO {

    private final CommunityReplyMapper communityReplyMapper;

//    --------------------------------   INSERT  ----------------------------------------------

    //댓글 등록
    public void save(CommunityReplyDTO communityReplyDTO){
        communityReplyMapper.insert(communityReplyDTO);
    }

    //대댓글 등록
    public void saveDepth(CommunityReplyDTO communityReplyDTO){
        communityReplyMapper.insertDepth(communityReplyDTO);
    }

    // 중간 테이블 삽입
    public void saveMiddle(CommunityReplyVO communityReplyVO){
        communityReplyMapper.insertMiddle(communityReplyVO);
    }

//    ---------------------------------- SELECT -------------------------------------------------

    //일반 댓글 전체 조회
    public List<CommunityReplyDTO> findAll(Long communityId, CommunityPagination communityPagination){
        return communityReplyMapper.selectAll(communityId, communityPagination);
    }

//    대댓글 전체 조회
    public List<CommunityReplyDTO> findAllAgain(Long communityId){
        return communityReplyMapper.selectAllAgain(communityId);
    }

//    중간테이블 조회
    public Optional<CommunityReplyVO> findMiddle(Long id){
        return communityReplyMapper.selectMiddle(id);
    }

//    원하는 댓글 조회
    public Optional<CommunityReplyDTO> find(Long id){
        return communityReplyMapper.select(id);
    }

//    원하는 댓글 포함 대댓글 조회
    public List<CommunityReplyDTO> findAgain(Long replyGroup){
        return communityReplyMapper.selectAgain(replyGroup);
    }

//    그 해당하는 게시글에 중간테이블 전체 조회
    public List<CommunityReplyVO> findMiddleAll(Long communityId){
        return communityReplyMapper.selectMiddleAll(communityId);
    }

//    일반댓글 대댓글 총개수
    public int findCountOfReply(Long communityId){
        return communityReplyMapper.selectCountOfReply(communityId);
    }

//    일반댓글 총개수
    public int findCount(Long communityId){
        return communityReplyMapper.selectCount(communityId);
    }

//    대댓글 총개수
    public int findCountOfReplyAgain(Long id, Long replyGroup){
        return communityReplyMapper.selectCountOfReplyAgain(id, replyGroup);
    }

//--------------------------- UPDATE ------------------------------------------

//   댓글 수정
    public void setCommunityReplyDTO(CommunityReplyDTO communityReplyDTO){
        communityReplyMapper.update(communityReplyDTO);
    }

//    --------------------------- DELETE --------------------------------------------

//    일반댓글, 대댓글 삭제
    public void delete(Long id){
        communityReplyMapper.delete(id);
    }

//    댓글 전체 삭제
    public void deleteAll(Long communityId){
        communityReplyMapper.deleteAll(communityId);
    }


//  대댓글 전체 삭제
    public void deleteReplyAgain(Long replyGroup){
        communityReplyMapper.deleteReplyAgain(replyGroup);
    }

//    중간 테이블 삭제
    public void deleteMiddle(Long id){
        communityReplyMapper.deleteMiddle(id);
    }


}
