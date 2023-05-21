package com.wegether.app.dao;

import com.wegether.app.domain.vo.LectureFileVO;
import com.wegether.app.mapper.LectureFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureFileDAO {

    private final LectureFileMapper lectureFileMapper;

    //파일등록
    public void save(LectureFileVO lectureFileVO){
        lectureFileMapper.insert(lectureFileVO);
    }

}
