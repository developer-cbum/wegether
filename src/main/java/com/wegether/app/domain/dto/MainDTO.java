package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MainDTO {
    public Long id;
    private String projectTitle;
    private String memberId;
    private String memberName;


}
