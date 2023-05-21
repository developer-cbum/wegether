package com.wegether.app.dao;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.domain.dto.LectureFileDTO;
import com.wegether.app.domain.vo.LectureFileVO;
import com.wegether.app.mapper.LectureFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class LectureFileDAO {

    private final LectureFileMapper lectureFileMapper;

    //파일등록
    public void save(LectureFileDTO lectureFileDTO){
        lectureFileMapper.insert(lectureFileDTO);
    }

    //파일 중간테이블추가
    public void saveMiddle(Long fileId, Long lectureId){
        lectureFileMapper.insertMiddle(fileId, lectureId);
    }

    //파일 DTO 모두 가져오기
    public List<LectureFileDTO> lectureFindAll(Long lectureId){
       return lectureFileMapper.lectureSelectAll(lectureId);
    }

}
