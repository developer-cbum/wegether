package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CommunityReplyDTO {
    private Long id;
    private String replyContent;
    private Long replyGroup;
    private Long replyDepth;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private Long memberId;
    private Long communityId;
    private String memberNickname;
}
