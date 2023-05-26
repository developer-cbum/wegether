package com.wegether.app.dao.project;

import com.wegether.app.dao.ProjectDAO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ProjectDAOTests {

    @Autowired
    private ProjectDAO projectDAO;

//    @Test
//    public void projectFindAllTest() {
//        ProjectPagination projectPagination = new ProjectPagination();
//        projectPagination.setPage(1);
//        projectDAO.projectFindAll(projectPagination).stream().map(ProjectDTO::toString).forEach(log::info);
//    }

//    @Test
//    public void findByIdTest() {
//        projectDAO.findById(2L).map(ProjectDTO::toString).ifPresent(log::info);
//    }

//    @Test
//    public void projectSaveTest() {
//        ProjectDTO projectDTO = new ProjectDTO();
//        projectDTO.setId(1L);
//        projectDTO.setMemberId(21L);
//        projectDTO.setProjectTitle("제목입니다");
//        projectDTO.setProjectIntroducing("소개글입니다");
//        projectDTO.setProjectMajor("경영학과");
//        projectDTO.setProjectSchool("서울대");
//        projectDTO.setProjectRegisterDate("2023-05-21");
//        projectDTO.setProjectUpdateDate("SYSDATE");
//        projectDTO.setProjectEndDate("내일까지");
//        projectDTO.setProjectReadCount(5L);
//        projectDTO.setProjectNowPersonnel(10);
//        projectDTO.setProjectTotalPersonnel(50);
//        projectDAO.projectSave(projectDTO);
//    }

//    @Test
//    public void setProjectDAOTest() {
//        Optional<ProjectDTO> foundProject = projectDAO.findById(25L);
//        if (foundProject.isPresent()) {
//            ProjectDTO projectDTO = foundProject.get();
//            projectDTO.setProjectTitle("내가 돌아왔다");
//            projectDAO.setProjectDTO(projectDTO);
//        } else {
//        }
//
//        foundProject = projectDAO.findById(1L);
//        foundProject.ifPresent(project -> assertThat(project.getProjectTitle()).isEqualTo("내가 돌아왔다"));
//    }
//    @Test
//    public void deleteTest() {
//        projectDAO.ProjectDelete(25L);
//    }


}
