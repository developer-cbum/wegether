package com.wegether.app.dao.data;

import com.wegether.app.dao.CommunityFileDAO;
import com.wegether.app.dao.DataFileDAO;
import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.DataFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class DataFileDAOTests {

    @Autowired
    private DataFileDAO dataFileDAO;

    @Autowired
    private FileDAO fileDAO;

    @Test
    public void saveTest() {
        DataFileDTO dataFileDTO = new DataFileDTO();
        dataFileDTO.setFileName("icon2.png");
        dataFileDTO.setFileSize(1238L);
        dataFileDTO.setDataId(1L);
        dataFileDTO.setFileUuid(UUID.randomUUID().toString());
        log.info(dataFileDTO.toString());
        fileDAO.save(dataFileDTO);
    }


    @Test
    public void dataFileSaveTest(){
        DataFileVO dataFileVO = new DataFileVO();
        dataFileVO.setId(1L);
        dataFileVO.setDataId(1L);
        dataFileDAO.save(dataFileVO);
    }

//    @Test
//    public void selectAllTest() {
//        fileDAO.findAll(1L).stream().map(DataFileDTO::toString).forEach(log::info);
//    }
}
