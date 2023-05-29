package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PointDTO {
    private Long id;
    private Long memberId;
    private Long pointHistory;
    private String pointCategory;
    private String pointRegisterDate;
    private Long memberPoint;
    private Long dataId;
    private String dataTitle;
    private String dataSchool;
    private String dataMajor;
    private String memberName;
    private Long getMemberPoint;
}
