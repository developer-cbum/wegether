package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class AnswerAdminDTO {
    private Long id;
    private String inquiryTitle;
    private String memberNickname;
    private String inquiryRegisterDate;
    private String inquiryContent;
    private String answerRegisterDate;
    private String answerContent;
    private Long inquiryId;
}
