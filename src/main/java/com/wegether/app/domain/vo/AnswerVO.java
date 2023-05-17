package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AnswerVO {
    private Long id;
    private String answerContent;
    private String answerRegisterDate;
    private Long inquiryId;
}
