package com.wegether.app.mapper.lecture;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.mapper.LectureMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LectureMapperTest {

    @Autowired
    private LectureMapper lectureMapper;

//    강연등록
    @Test
    public void insertTest(){
        LectureDTO lectureDTO = new LectureDTO();
        lectureDTO.setLectureTitle("안녕");
        lectureDTO.setLectureContent("해보자");
        lectureDTO.setLectureDate("5월30일");
        lectureDTO.setLectureTime("오후2시");
        lectureDTO.setLectureLocation("강남");
        lectureDTO.setLectureTotalPersonnel(100);
        lectureMapper.insert(lectureDTO);
    }

}
