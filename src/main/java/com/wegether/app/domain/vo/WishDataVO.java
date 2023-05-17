package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class WishDataVO {
    private Long id;
    private Long memberId;
    private Long dataId;
}
