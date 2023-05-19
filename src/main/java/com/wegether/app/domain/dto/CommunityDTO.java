package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CommunityDTO {
    private Long id;
    private String communityTitle;
    private String communitySubtitle;
    private String communityContent;
    private String communityRegisterDate;
    private String communityUpdateDate;
    private Long memberId;
    private String memberName;
    private String memberNickname;
    private List<FileVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
