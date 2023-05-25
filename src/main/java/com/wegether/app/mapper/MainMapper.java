package com.wegether.app.mapper;

import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainPagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.NoticeVO;
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
    public List<MainDTO> searchPSelectAll(@Param("mainPagination") MainPagination mainPagination);

    // 프로젝트 총 갯수
    public int selectCountOfProject();

//    자료실 목록
    public List<MainDTO> searchDSelectAll(@Param("mainPagination") MainPagination mainPagination);

//    자료실 총 갯수
    public int selectCountOfData();



}