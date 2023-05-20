package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.CommunityFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CommunityFileDTO {
    private Long id;
    private Long communityId;
    private String filePath;
    private String fileUuid;
    private String fileName;
    private Long fileSize;
//    private List<CommunityFileVO> communityFiles = new ArrayList<>();
}
