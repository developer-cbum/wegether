package com.wegether.app.dao.community;

import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.dao.ReplyDAO;
import com.wegether.app.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CommunityReplyDAOTests {

    @Autowired
    private ReplyDAO replyDAO;

    @Test
    public void saveTest() {
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyContent("까우링스딸밤하늘의퍼어얼");
        replyVO.setReplyGroup(3);
        replyVO.setReplyDepth(2);
        replyDAO.communitySave(replyVO);
    }
}
