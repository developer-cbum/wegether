package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProjectMapper {




    // 프로젝트 목록
    public List<ProjectDTO> projectSelectAll(ProjectPagination projectPagination);

    // 프로젝트 등록
    public void projectInsert(ProjectDTO projectDTO);

    // 프로젝트  상세
    public Optional<ProjectDTO> select(Long id);

    // 프로젝트  수정
    public void ProjectUpdate(ProjectDTO projectDTO);

    // 프로젝트 삭제
    public void ProjectDelete(Long id);










//    소영 마이페이지 추가

    public List<ProjectDTO> selectmyProject (Long memberId);
}
