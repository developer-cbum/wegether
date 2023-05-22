package com.wegether.app.mapper;

import com.wegether.app.domain.dto.MainFileDTO;
import com.wegether.app.domain.vo.DataFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainFileMapper {

    public List<MainFileDTO> MainPFSelectAll(Long projectId);

    //    파일 조회
    public MainFileDTO MainPFSelect(Long id);

}