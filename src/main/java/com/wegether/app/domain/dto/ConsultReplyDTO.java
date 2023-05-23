package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ConsultReplyDTO {
    private Long id;
    private String replyContent;
    private Long replyGroup;
    private Long replyDepth;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private Long memberId;
    private Long consultingId;
    private String memberNickname;
}