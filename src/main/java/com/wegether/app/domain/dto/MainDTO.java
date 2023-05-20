package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MainDTO {
    public Long id;
    private String projectTitle;
    private String projectContent;
    private String projectRegisterDate;
    private String projectUpdateDate;
    private String projectEndDate;
    private Long projectReadCount;
    private Long nowPersonnel;
    private Long totalPersonnel;
    private String projectMajor;
    private String projectSchool;
    private String dataTitle;
    private String memberId;
    private String memberName;



}
