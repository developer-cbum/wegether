package com.wegether.app.mapper.main;

import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainFileDTO;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.mapper.FileMapper;
import com.wegether.app.mapper.MainFileMapper;
import com.wegether.app.mapper.MainMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MainMapperTests {

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private MainMapper mainMapper;

    @Autowired
    private MainFileMapper mainFileMapper;

    @Test
    public void mainPSelectAllTest() {
        assertThat(mainMapper.mainPSelectAll()).hasSize(5);
    }

    @Test
    public void mainDSelectAllTest() {
        assertThat(mainMapper.mainDSelectAll()).hasSize(5);
    }


    @Test
    public void mainCSelectAllTest() {
        assertThat(mainMapper.mainCSelectAll()).hasSize(1);
    }

    @Test
    public void mainPFSelectAllTest() {
        mainFileMapper.mainPFSelectAll(1L).stream().map(MainFileDTO::toString).forEach(log::info);
    }

    @Test
    public void mainDFSelectAllTest() {
        mainFileMapper.mainDFSelectAll(1L).stream().map(MainFileDTO::toString).forEach(log::info);
    }

    @Test
    public void mainCFSelectAllTest() {
        mainFileMapper.mainCFSelectAll(1L).stream().map(MainFileDTO::toString).forEach(log::info);
    }

    @Test
    public void searchSPSelectAllTest(){
        assertThat(mainMapper.searchPSelectAll()).hasSize(5);
    }


    }