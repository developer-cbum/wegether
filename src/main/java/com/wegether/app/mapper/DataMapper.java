package com.wegether.app.mapper;

import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DataMapper {
//    자료 목록 조회
    public List<DataDTO> selectAll(@Param("pagination") Pagination pagination);

//    자료 추가
    public void insert(DataDTO dataDTO);

//    자료 상세 조회
    public Optional<DataDTO> select(Long id);

}
