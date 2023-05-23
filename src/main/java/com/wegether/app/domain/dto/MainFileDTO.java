package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MainFileDTO {
    private Long id;
    private Long projectId;
    private Long communityId;
    private Long dataId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
    private String fileType;
}
