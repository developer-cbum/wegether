package com.wegether.app.mapper;

import com.wegether.app.domain.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
//    메인페이지 프로젝트 목록
    public List<MainDTO> mainPSelectAll();
//    메인페이지 커뮤니티 목록
    public List<MainDTO> mainCSelectAll();
//    메인페이지 자료실 최근 목록
    public List<MainDTO> mainDSelectAll();
//    메인페이지 자료실 조회수 목록
    public List<MainDTO> mainDRSelectAll();

    // 프로젝트 목록
    public List<MainDTO> searchPSelectAll(@Param("mainProjectPagination") MainProjectPagination mainProjectPagination, @Param("search") Search search);

    // 프로젝트 총 갯수
    public int selectCountOfProject(Search search);

//    자료실 목록
//    public List<MainDTO> searchDSelectAll(@Param("mainDataPagination") MainDataPagination mainDataPagination, @Param("search") Search search);
//
////    자료실 총 갯수
//    public int selectCountOfData(Search search);



}