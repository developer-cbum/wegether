package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PayVO {
    private Long id;
    private Long memberId;
    private Long dataId;
    private Long payTotalPrice;
    private Long payPointUse;
    private String payRegisterDate;
    private boolean payStatus;
}
