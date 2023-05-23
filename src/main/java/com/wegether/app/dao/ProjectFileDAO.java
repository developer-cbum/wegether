package com.wegether.app.dao;

import com.wegether.app.domain.vo.DataFileVO;
import com.wegether.app.domain.vo.ProjectFileVO;
import com.wegether.app.mapper.ProjectFileMapper;
import com.wegether.app.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectFileDAO {
    private final ProjectFileMapper projectFileMapper;

    //   file list
    public List<ProjectFileVO> findProjectFiles(Long projectId) {
        return projectFileMapper.selectAll(projectId);
    };

    //    파일 조회
    public List<ProjectFileVO> findById(Long projectId){
        return projectFileMapper.selectAll(projectId);
    }

    //    파일 추가
    public void save(ProjectFileVO projectFileVO){
        projectFileMapper.insert(projectFileVO);
    }

//    //    파일 삭제
//    public void delete(Long id){
//        projectFileMapper.delete(id);
//    }

}
