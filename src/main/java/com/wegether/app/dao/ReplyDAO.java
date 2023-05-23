package com.wegether.app.dao;

import com.wegether.app.domain.vo.ReplyVO;
import com.wegether.app.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {

    private final ReplyMapper replyMapper;

    public void communitySave(ReplyVO replyVO){
        replyMapper.communityInsert(replyVO);
    }
}
