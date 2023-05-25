package com.wegether.app.dao;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.type.CategoryType;
import com.wegether.app.domain.vo.ProjectVO;
import com.wegether.app.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectDAO {
    private final ProjectMapper projectMapper;


    // 프로젝트 목록
    public List<ProjectDTO> projectFindAll(ProjectPagination projectPagination){
        return projectMapper.projectSelectAll(projectPagination);
    }

    // 프로젝트 총 갯수
    public int findCountOfProject() { return projectMapper.selectCountOfProject(); }


//    // 프로젝트 등록
//    public void projectSave(ProjectDTO projectDTO){
//        projectMapper.projectInsert(projectDTO);
//    }
//
//    // 프로젝트  상세
//    public Optional<ProjectDTO> findById(Long id){
//        return projectMapper.select(id);
//    }

    // 프로젝트  수정
//    public void setProjectDTO(ProjectDTO projectDTO){
//        projectMapper.ProjectUpdate(projectDTO);
//    }


    // 프로젝트 삭제
//    public void ProjectDelete(Long id){
//        projectMapper.ProjectDelete(id);
//    }












//    소영 마이페이지
    public List<ProjectDTO> showmyProject(Long memberId){
        return projectMapper.selectmyProject(memberId);
    }


}
