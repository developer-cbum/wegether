package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CardVO {
    private Long id;
    private Long memberId;
    private String cardNumber;
    private String cardExpireDate;
    private String cardPassword;
    private String memberBirthDate;
    private String cardRegisterDate;
}
