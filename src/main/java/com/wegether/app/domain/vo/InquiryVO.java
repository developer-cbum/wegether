package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class InquiryVO {
    private Long id;
    private Long memberId;
    private String InquiryTitle;
    private String InquiryContent;
    private String InquiryRegisterDate;
}
