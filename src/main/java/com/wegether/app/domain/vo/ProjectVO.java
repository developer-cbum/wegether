package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class ProjectVO {
    private Long id;
    private Long memberId;
    private String projectTitle;
    private String projectIntroducing;
    private String projectMajor;
    private String projectSchool;
    private String projectRegisterDate;
    private String projectUpdateDate;
    private String projectEndDate;
    private Long projectReadCount;
    private int projectNowPersonnel;
    private int projectTotalPersonnel;

}
