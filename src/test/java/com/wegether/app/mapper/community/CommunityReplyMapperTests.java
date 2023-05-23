package com.wegether.app.mapper.community;

import com.wegether.app.domain.vo.ReplyVO;
import com.wegether.app.mapper.CommunityReplyMapper;
import com.wegether.app.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityReplyMapperTests {

    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void communityInsertTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyContent("까우링스딸밤하늘의퍼어얼");
        replyVO.setReplyGroup(3);
        replyVO.setReplyDepth(2);
        replyMapper.communityInsert(replyVO);
    }
}
