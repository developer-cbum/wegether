package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataFileDTO {
    private Long id;
    private Long dataId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
}
