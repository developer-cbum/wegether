package com.wegether.app.mapper;

import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
    public List<MainDTO> mainPSelectAll();

    public List<MainDTO> mainCSelectAll();

    public List<MainDTO> mainDSelectAll();

    public List<MainDTO> mainDRSelectAll();

}