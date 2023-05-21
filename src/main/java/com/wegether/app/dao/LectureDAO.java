package com.wegether.app.dao;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureDAO {

    private final LectureMapper lectureMapper;

    //강연등록
    public void save(LectureDTO lectureDTO){
        lectureMapper.insert(lectureDTO);
    }


}
