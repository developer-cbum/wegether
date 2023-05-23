package com.wegether.app.mapper;

import com.wegether.app.domain.vo.ProjectFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectFileMapper {

    public List<ProjectFileVO> selectAll(Long projectId);

    public ProjectFileVO select(Long id);

    public void insert(ProjectFileVO projectFileVO);

//    public void projectdelete(Long id);

}
