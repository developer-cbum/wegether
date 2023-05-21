package com.wegether.app.mapper;

import com.wegether.app.domain.dto.LectureDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureMapper {

    //강연 등록
    public void insert(LectureDTO lectureDTO);

}
