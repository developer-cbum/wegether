package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ConsultingReplyVO {
    private Long id;
    private Long memberId;
    private Long consultingId;
}

