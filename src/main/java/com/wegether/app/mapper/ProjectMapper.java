package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProjectMapper {

    public List<ProjectDTO> projectSelectAll();

    // 프로젝트 등록
    public void projectInsert(ProjectVO projectVO);

    // 프로젝트  상세
    public Optional<ProjectVO> ProjectSelect(Long id);

    // 프로젝트  수정
    public void ProjectUpdate(ProjectVO projectVO);

    // 프로젝트 삭제
    public void projectDelete(Long id);

}
