package com.wegether.app.mapper.project;


import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.NoticeVO;
import com.wegether.app.domain.vo.ProjectVO;
import com.wegether.app.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j

public class ProjectMapperTests {
    @Autowired
    private ProjectMapper projectMapper;


    //등록 테스트
    @Test
    public void insertTest(){
        ProjectVO ProjectVO=new ProjectVO();
        ProjectVO.setMemberId(1L);
        ProjectVO.setProjectTitle("테스트 제목");
        ProjectVO.setProjectIntroducing("테스트 소개");
        ProjectVO.setProjectMajor("컴퓨터 공학과");
        ProjectVO.setProjectSchool("학교");
        ProjectVO.setProjectRegisterDate("SYSDATE");
        ProjectVO.setProjectUpdateDate("SYSDATE");
        ProjectVO.setProjectEndDate("지금");
        ProjectVO.setProjectReadCount(1L);
        ProjectVO.setProjectNowPersonnel(10);
        ProjectVO.setProjectTotalPersonnel(50);
        projectMapper.projectInsert(ProjectVO);
    }
    //목록 테스트
    @Test
    public void projectSelectAllTest() { assertThat(projectMapper.projectSelectAll()).hasSize(1); }

    //상세 테스트
    @Test
    public void selectTest() {
        Long projectId = 1L;

        Optional<ProjectDTO> projectOptional = projectMapper.select(projectId);

    }

        //업데이트 테스트
    @Test
    public void projectUpdateTest() {
        projectMapper.select(2L).ifPresent(projectDTO -> {
            projectDTO.setProjectTitle("수정된 제목");
            projectMapper.ProjectUpdate(projectDTO);
        });

    }


    //프로젝트 삭제 테스트
    @Test
        public void projectDeleteTest() {
        Long projectId = 1L;
    }
}