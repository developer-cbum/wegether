package com.wegether.app.mapper.project;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectFileDTO;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.mapper.FileMapper;
import com.wegether.app.mapper.ProjectFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class ProjectFileMapperTests {

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private ProjectFileMapper projectFileMapper;

    @Test
    public void insertTest() {
        ProjectFileDTO projectFileDTO = new ProjectFileDTO();
        projectFileDTO.setFileName("icon1.png");
        projectFileDTO.setFilePath("2023/05/22");
        projectFileDTO.setFileSize(555L);
        projectFileDTO.setFileUuid(UUID.randomUUID().toString());
        projectFileDTO.setFileType(FileType.REPRESENTATIVE.name());
        fileMapper.insert(projectFileDTO);
    }

    @Test
    public void projectSelectAllTest() {
        fileMapper.projectSelectAll(1L).stream().map(ProjectFileDTO::toString).forEach(log::info);
    }


}
