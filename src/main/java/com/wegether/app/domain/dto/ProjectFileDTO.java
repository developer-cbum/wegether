package com.wegether.app.domain.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectFileDTO {
    private Long id;
    private Long projectId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
    private String fileType;
}
