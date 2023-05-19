package com.wegether.app.mapper.project;


import com.wegether.app.domain.vo.ProjectVO;
import com.wegether.app.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectMapperTests {

    @Autowired
    private ProjectMapper projectMapper;


    @Test
    public void insertTest(){
        ProjectVO projectVO=new ProjectVO();
        projectVO.setMemberId(1L);
        projectVO.setProjectTitle("테스트 제목");
        projectVO.setProjectIntroducing("테스트 소개");
        projectVO.setProjectMajor("컴퓨터 공학과");
        projectVO.setProjectSchool("학교");
        projectVO.setProjectRegisterDate("SYSDATE");
        projectVO.setProjectUpdateDate("SYSDATE");
        projectVO.setProjectEndDate("지금");
        projectVO.setProjectReadCount(1L);
        projectVO.setProjectNowPersonnel(10);
        projectVO.setProjectTotalPersonnel(50);
        projectMapper.projectInsert(projectVO);
    }
    @Test
    public void selectTest(){

    }


}

