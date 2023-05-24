package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class NoticeFileAdminDTO {
    private Long id;
    private Long noticeId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
    private String fileType;

}
