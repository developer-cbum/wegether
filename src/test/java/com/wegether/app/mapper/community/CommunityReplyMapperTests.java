package com.wegether.app.mapper.community;

import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.vo.ReplyVO;
import com.wegether.app.mapper.CommunityReplyMapper;
import com.wegether.app.mapper.ConsultingReplyMapper;
import com.wegether.app.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityReplyMapperTests {


    @Autowired
    private CommunityReplyMapper communityReplyMapper;

    //댓글 등록
    @Test
    public void insertTest(){
        CommunityReplyDTO communityReplyDTO = new CommunityReplyDTO();
        communityReplyDTO.setReplyContent("댓글이용");
        communityReplyMapper.insert(communityReplyDTO);
        communityReplyDTO.getId();
    }



    // 대댓글 등록
    @Test
    public void insertReplyAgainTest(){
        CommunityReplyDTO communityReplyDTO = new CommunityReplyDTO();
        communityReplyDTO.setReplyContent("대댓글이용");
        // 그 댓글의 아이디
        communityReplyDTO.setReplyGroup(1L);

        communityReplyMapper.insertDepth(communityReplyDTO);
    }



//    @Test
//    //일반 댓글 페이징을 가져오기
//    public void selectAllTest(){
//        CommunityPagination communityPagination = new CommunityPagination();
//        communityPagination.progress(5, 5);
//       communityReplyMapper.selectAll(communityPagination);
//    }


}
