package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MainDTO {
    public Long id;
    private String projectTitle;
    private String projectMajor;
    private String projectSchool;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
    private String dataTitle;
    private Long dataReadCount;
    private String dataRegisterDate;
    private String communityTitle;
    private String communityRegisterDate;



}
