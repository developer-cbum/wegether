package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LectureFileVO {
    private Long id;
    private Long fileId;
    private Long lectureId;
}