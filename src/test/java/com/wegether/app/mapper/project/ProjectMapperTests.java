package com.wegether.app.mapper.project;


import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import com.wegether.app.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
//@SpringBootTest
//@Slf4j

//public class ProjectMapperTests {
////    @Autowired
//    private ProjectMapper projectMapper;
//
//
//    //등록 테스트
//    @Test
//    public void insertTest(){
//        ProjectDTO projectDTO = new ProjectDTO();
//        projectDTO.setMemberId(1L);
//        projectDTO.setProjectTitle("테스트 제목");
//        projectDTO.setProjectIntroducing("테스트 소개");
//        projectDTO.setProjectMajor("컴퓨터 공학과");
//        projectDTO.setProjectSchool("학교");
//        projectDTO.setProjectRegisterDate("SYSDATE");
//        projectDTO.setProjectUpdateDate("SYSDATE");
//        projectDTO.setProjectEndDate("지금");
//        projectDTO.setProjectReadCount(1L);
//        projectDTO.setProjectNowPersonnel(10);
//        projectDTO.setProjectTotalPersonnel(50);
//        projectMapper.projectInsert(projectDTO);
//    }
//    //목록 테스트
//    @Test
//    public void projectSelectAllTest() {
//        ProjectPagination projectPagination = new ProjectPagination();
//        projectPagination.setPage(1);
//        projectMapper.projectSelectAll(projectPagination).stream().map(ProjectDTO::toString).forEach(log::info);
//    }
//
//    //상세 테스트
//    @Test
//    public void selectTest() {
//        Long projectId = 1L;
//
//        Optional<ProjectDTO> projectOptional = projectMapper.select(projectId);
//
//    }
//
//        //업데이트 테스트
//    @Test
//    public void projectUpdateTest() {
//       Optional<ProjectDTO> foundProject = projectMapper.select(2L);
//        foundProject.ifPresent(projectDTO -> projectDTO.setProjectTitle("타이틀수정"));
//        foundProject.ifPresent(projectDTO -> projectDTO.setProjectIntroducing("소개 수정"));
//        foundProject.ifPresent(projectDTO -> projectDTO.setProjectMajor("전공수정"));
//
//        ProjectDTO projectDTO = foundProject.orElseThrow();
//
//        projectMapper.ProjectUpdate(projectDTO);
//
//        foundProject = projectMapper.select(2L);
//
//        foundProject.ifPresent(project -> assertThat(project.getProjectTitle()).isEqualTo("제목수정"));
//    }
//
//
//    //프로젝트 삭제 테스트
//    @Test
//        public void projectDeleteTest() {
//        Long projectId = 1L;
//    }
//






//
////    소영 테스트
//    @Test
//    public void selectmyProjectTest(){
//        assertThat(projectMapper.selectmyProject(1L)).hasSize(2);
//    }
//}