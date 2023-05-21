package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class InquiryDTO {
    private Long id;
    private Long memberId;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryRegisterDate;
    private String answerContent;
}
