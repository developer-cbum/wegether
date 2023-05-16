package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CardVO {
    private Long id;
    private String cardNumber;
    private String cardBirthDate;
    private String cardPassword;
    private String cardRegisterDate;
    private Long memberId;
}
