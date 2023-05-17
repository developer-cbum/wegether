package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityReplyVO {
    private Long id;
    private Long replyId;
    private Long CommunityId;
    private Long memberId;
}

