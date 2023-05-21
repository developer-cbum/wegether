package com.wegether.app.mapper;

import com.wegether.app.domain.vo.LectureFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureFileMapper {

    public void insert(LectureFileVO lectureFileVO);
}
