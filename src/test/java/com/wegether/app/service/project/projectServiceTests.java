package com.wegether.app.service.project;

import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class projectServiceTests {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private FileDAO fileDAO;


//    @Test
//
//    void getListTest() {
//        ProjectPagination projectPagination = new ProjectPagination();
//        projectPagination.setPage(1);
//        projectService.getList(projectPagination).stream().map(ProjectDTO::toString).forEach(log::info);
//    }

//    @Test
//    public void findByIdTest() {
//        projectService.getProject(1L).map(ProjectDTO::toString).ifPresent(log::info);
//    }

//    @Test
//    void findByIdTest() {
//        projectService.getProject(1L).map(ProjectDTO::toString).ifPresent(log::info);
//    }


    @Test
    void writeTest(){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(1L);
        projectDTO.setMemberId(1L);
        projectDTO.setProjectTitle("제목입니다");
        projectDTO.setProjectIntroducing("소개글입니다");
        projectDTO.setProjectMajor("경영학과");
        projectDTO.setProjectSchool("서울대");
        projectDTO.setProjectRegisterDate("2023-05-21");
        projectDTO.setProjectUpdateDate("SYSDATE");
        projectDTO.setProjectEndDate("내일까지");
        projectDTO.setProjectReadCount(5L);
        projectDTO.setProjectNowPersonnel(10);
        projectDTO.setProjectTotalPersonnel(50);
        projectService.write(projectDTO);
    }


//    @Test
//    public void modifyTest() {
//        Optional<ProjectDTO> foundProject = projectService.getProject(20L);
//        if (foundProject.isPresent()) {
//            ProjectDTO projectDTO = foundProject.get();
//            projectDTO.setProjectTitle("제에목수정");
//            projectService.modify(projectDTO);
//            foundProject = projectService.getProject(20L);
//            foundProject.ifPresent(project -> assertThat(project.getProjectTitle()).isEqualTo("제에목수정"));
//        } else {
//        }
//    }

//    @Test
//    void modifyTest() {
//        Optional<ProjectDTO> foundProject = projectService.getProject(20L);
//        if (foundProject.isPresent()) {
//            ProjectDTO projectDTO = foundProject.get();
//            projectDTO.setProjectTitle("제에목수정");
//            projectService.modify(projectDTO);
//            foundProject = projectService.getProject(20L);
//            foundProject.ifPresent(project -> assertThat(project.getProjectTitle()).isEqualTo("제에목수정"));
//        } else {
//        }
//    }


//    @Test
//    public void removeTest() {
//        projectService.remove(1L);
//    }

}
