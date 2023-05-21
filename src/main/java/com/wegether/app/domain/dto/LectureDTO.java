package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class LectureDTO {
    private Long id;
    private String lectureTitle;
    private String lectureContent;
    private String lectureDate;
    private String lectureTime;
    private String lectureLocation;
    private int lectureTotalPersonnel;
    private String lectureRegisterDate;
    private String lectureUpdateDate;
    private Long memberId;
    private List<FileVO> files = new ArrayList<>();
    private List<Long> filesIdsForDelete = new ArrayList<>();
}
