package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityVO {
    private Long id;
    private String CommunityTitle;
    private String CommunitySubtitle;
    private String CommunityContent;
    private String CommunityRegisterDate;
    private String CommunityUpdateDate;
    private Long memberId;
}