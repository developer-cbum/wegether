package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.ProjectVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ProjectDTO{
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






//    private List<ProjectFileDTO> files = new ArrayList<>();
//    private List<Long> fileIdsForDelete = new ArrayList<>();


    


//    소영 추가
    private String info;
    private String register;
    private String now;
    private String inum;
}
