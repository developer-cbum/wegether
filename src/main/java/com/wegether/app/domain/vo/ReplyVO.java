package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long id;
//    private Long memberId;
//    private Long postId;
    private String replyContent;
    private int replyIndex;
    private int replyOrder;
    private int replyGroupNum;
    private int replyClass;
    private String replyRegisterDate;
    private String replyUpdateDate;
}
