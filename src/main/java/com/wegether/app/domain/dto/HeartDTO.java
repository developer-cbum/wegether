package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class HeartDTO {
    private Long id;
    private Long memberId;
    private String projectTitle;
    private String projectIntroducing;
    private String projectMajor;
    private String projectSchool;
    private String projectRegisterDate;
    private String projectUpdateDate;
    private String projectEndDate;
    private Long projectReadCount;
    private int projectNowPersonnel;
    private int projectTotalPersonnel;


    private String dataTitle;
    private String dataContent;
    private Long dataPrice;
    private String dataSchool;
    private String dataMajor;
    private Long dataReadCount;
    private String dataRegisterDate;
    private String dataUpdateDate;
    private String memberNickname;
    private String memberSchool;
    private String memberMajor;
    private String memberIntroducing;
    private Long dataId;
    //    private Long WishDataId;
//    private List<FileVO> files = new ArrayList<>();
    private List<DataFileDTO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();





//    private List<ProjectFileDTO> files = new ArrayList<>();
//    private List<Long> fileIdsForDelete = new ArrayList<>();



    //    소영 추가
    private String info;
    private String register;
    private String now;
    private String inum;
    private String title;
    private String sub;


}
