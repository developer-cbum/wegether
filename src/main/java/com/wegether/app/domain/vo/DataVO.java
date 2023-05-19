package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class DataVO {
    private Long id;
    private Long memberId;
    private String dataTitle;
    private String dataContent;
    private Long dataPrice;
    private String dataSchool;
    private String dataMajor;
    private Long dataReadCount;
    private String dataRegisterDate;
    private String dataUpdateDate;
}
