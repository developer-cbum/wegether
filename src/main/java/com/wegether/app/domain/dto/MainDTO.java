package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    private byte[] imageData;
    private List<FileVO> files = new ArrayList<>();



}
