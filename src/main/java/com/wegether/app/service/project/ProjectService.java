package com.wegether.app.service.project;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.type.CategoryType;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.domain.vo.ProjectVO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    // 프로젝트 목록
    public List<ProjectDTO> getList(ProjectPagination projectPagination);

    // 프로젝트 총 갯수
    public int getProjectTotal();

//    // 프로젝트 등록
    public void write(ProjectDTO projectDTO);
//
//    // 프로젝트  수정
////    public void modify(ProjectDTO projectDTO);
   //    게시글 조회
    public Optional<ProjectDTO> read(Long id);



//    public int getTotal();

}





















