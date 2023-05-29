package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
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
    private Long fileId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private String memberLoginStatus;
    private String snsProfile;
}
