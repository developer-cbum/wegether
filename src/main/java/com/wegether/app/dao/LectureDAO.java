package com.wegether.app.dao;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureDAO {

    private final LectureMapper lectureMapper;

    //강연등록
    public void save(LectureDTO lectureDTO){
        lectureMapper.insert(lectureDTO);
    }

    //강연 게시글 목록
    public List<LectureDTO> findAll(LecturePagination lecturePagination){
        return lectureMapper.selectAll(lecturePagination);
    }

    //강연 총 개수
    public int findCountOfLecture(){
        return lectureMapper.selectCountOfLecture();
    }


}
