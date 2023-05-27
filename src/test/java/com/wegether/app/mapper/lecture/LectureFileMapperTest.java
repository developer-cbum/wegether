package com.wegether.app.mapper.lecture;

import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.dto.LectureFileDTO;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.mapper.DataFileMapper;
import com.wegether.app.mapper.FileMapper;
import com.wegether.app.mapper.LectureFileMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class LectureFileMapperTest {
    @Autowired
    private LectureFileMapper lectureFileMapper;


    @Test
    public void insertTest() {
        LectureFileDTO lectureFileDTO = new LectureFileDTO();
        lectureFileDTO.setFileName("title.png");
        lectureFileDTO.setFilePath("2023/05/20");
//        lectureFileDTO.setFileSize(999L);
        lectureFileDTO.setFileUuid(UUID.randomUUID().toString());
        lectureFileDTO.setFileType(FileType.NON_REPRESENTATIVE.name());
        lectureFileMapper.insert(lectureFileDTO);
    }


}
