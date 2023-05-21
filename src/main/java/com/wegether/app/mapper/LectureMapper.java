package com.wegether.app.mapper;

import com.wegether.app.domain.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LectureMapper {

    //강연 등록
    public void insert(LectureDTO lectureDTO);


    //강연 게시글 목록
    public List<LectureDTO> selectAll(LecturePagination lecturePagination);

    //강연 총 개수
    public int selectCountOfLecture();

}
