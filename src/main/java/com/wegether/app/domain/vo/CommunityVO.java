package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityVO {
    private Long id;
    private String communityTitle;
    private String communitySubtitle;
    private String communityContent;
    private String communityRegisterDate;
    private String communityUpdateDate;
    private Long memberId;
}