package com.wegether.app.mapper;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.domain.dto.LectureFileDTO;
import com.wegether.app.domain.vo.LectureFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureFileMapper {

    //파일추가
    public void insert(LectureFileDTO lectureFileDTO);


    //파일 중간테이블추가
    public void insertMiddle(LectureFileVO lectureFileVO);

    //파일 DTO 모두 가져오기
    public List<LectureFileDTO> lectureSelectAll(Long lectureId);

}
