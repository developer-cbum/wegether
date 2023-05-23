package com.wegether.app.mapper;

import com.wegether.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {

    public void communityInsert(ReplyVO replyVO);
}
