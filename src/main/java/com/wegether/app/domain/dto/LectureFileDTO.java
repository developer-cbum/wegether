package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LectureFileDTO {
    private Long id;
    private Long lectureId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Double fileSize;
    private String fileType;
}
