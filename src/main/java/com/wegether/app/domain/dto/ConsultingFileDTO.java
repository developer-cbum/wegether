package com.wegether.app.domain.dto;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsultingFileDTO {
    private Long id;
    private Long consultingId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
    private String fileType;
}