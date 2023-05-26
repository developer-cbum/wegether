package com.wegether.app.dao.project;

import com.wegether.app.dao.FileDAO;
import com.wegether.app.dao.ProjectDAO;
import com.wegether.app.dao.ProjectFileDAO;
import com.wegether.app.domain.dto.ProjectFileDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class ProjectFileDAOTests {

    @Autowired
    private ProjectFileDAO projectFileDAO;

    @Autowired
    private FileDAO fileDAO;

//    @Test
//    public void saveTest() {
//        ProjectFileDTO projectFileDTO = new ProjectFileDTO();
//        projectFileDTO.setFileName("icon2.png");
//        projectFileDTO.setFileSize(1200L);
//        projectFileDTO.setFilePath("2023/05/19");
//        projectFileDTO.setFileUuid(UUID.randomUUID().toString());
//        log.info(projectFileDTO.toString());
//        fileDAO.save(projectFileDTO);
//    }


//    @Test
//    public void findAllTest(){
//        DataPagination dataPagination = new DataPagination();
//        dataPagination.setPage(1);
//        dataPagination.progress();
//        List<DataDTO> dataDTOS = dataDAO.findAll(dataPagination);
//        dataDTOS.stream().map(dataDTO -> dataDTO.toString()).forEach(log::info);
//    }

}
