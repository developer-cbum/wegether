package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class LectureVO {
    private Long id;
    private String lectureTitle;
    private String lectureContent;
    private String lectureDate;
    private String lectureTime;
    private String lectureLocation;
    private int lectureTotalPersonnel;
    private String lectureRegisterDate;
    private String lectureUpdateDate;
//    private Long memberId;
}
