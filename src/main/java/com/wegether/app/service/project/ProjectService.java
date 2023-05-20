package com.wegether.app.service.project;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.ProjectVO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    // 프로젝트 목록
    public List<ProjectDTO> getList();

    // 프로젝트 등록
    public void Write(ProjectVO projectVO);

    // 프로젝트  상세
    public Optional<ProjectDTO> read(Long id);

    // 프로젝트  수정
    public void modify(ProjectVO projectVO);

    // 프로젝트 삭제
    public void remove(Long id);



    default ProjectDTO toDTO(ProjectVO projectVO) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(projectVO.getId());
        projectDTO.setMemberId(projectVO.getMemberId());
        projectDTO.setProjectTitle(projectVO.getProjectTitle());
        projectDTO.setProjectIntroducing(projectVO.getProjectIntroducing());
        projectDTO.setProjectMajor(projectVO.getProjectMajor());
        projectDTO.setProjectSchool(projectVO.getProjectSchool());
        projectDTO.setProjectRegisterDate(projectVO.getProjectRegisterDate());
        projectDTO.setProjectUpdateDate(projectVO.getProjectUpdateDate());
        projectDTO.setProjectEndDate(projectVO.getProjectEndDate());
        projectDTO.setProjectReadCount(projectVO.getProjectReadCount());
        projectDTO.setProjectNowPersonnel(projectVO.getProjectNowPersonnel());
        projectDTO.setProjectTotalPersonnel(projectVO.getProjectTotalPersonnel());
        return projectDTO;
    }
}





















