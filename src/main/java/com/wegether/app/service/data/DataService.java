package com.wegether.app.service.data;

import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DataService {
    //    게시글 목록
    public List<DataDTO> getList(Pagination pagination);

    //    게시글 추가
    public void write(DataDTO postDTO);

    //    게시글 조회
    public Optional<DataDTO> read(Long id);


}




















