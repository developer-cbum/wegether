package com.wegether.app.mapper;

import com.wegether.app.domain.dto.MainDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
//    public List<MainDTO> selectProject(Long id);
//



public List<MainDTO> ProjectSelectAll();



}