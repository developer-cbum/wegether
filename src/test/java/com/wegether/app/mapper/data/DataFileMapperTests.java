package com.wegether.app.mapper.data;

import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.mapper.DataFileMapper;
import com.wegether.app.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class DataFileMapperTests {

//    @Autowired
//    private FileMapper fileMapper;
//
//    @Autowired
//    private DataFileMapper dataFileMapper;o9

//    @Test
//    public void insertTest() {
//        DataFileDTO dataFileDTO = new DataFileDTO();
//        dataFileDTO.setFileName("icon2.png");
//        dataFileDTO.setFilePath("2023/05/20");
//        dataFileDTO.setFileSize(999L);
//        dataFileDTO.setFileUuid(UUID.randomUUID().toString());
//        dataFileDTO.setFileType(FileType.REPRESENTATIVE.name());
//        fileMapper.insert(dataFileDTO);
//    }

//    @Test
//    public void dataSelectAllTest() {
//        fileMapper.dataSelectAll(1L).stream().map(DataFileDTO::toString).forEach(log::info);
//    }




}