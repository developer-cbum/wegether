package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class InquiryAdminDTO {
    private Long id;
    private Long memberId;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryRegisterDate;
    private String memberNickname;
    private boolean inquiryStatus;
    private Long inquiryId;
}
