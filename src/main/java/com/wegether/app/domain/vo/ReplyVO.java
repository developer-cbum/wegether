package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long id;
    private String replyContent;
    private int replyDepth;
    private int replyGroup;
    private String replyRegisterDate;
    private String replyUpdateDate;
}
