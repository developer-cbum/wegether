package com.wegether.app.mapper.main;

import com.wegether.app.mapper.MainMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MainMapperTests {

    @Autowired
    private MainMapper mainMapper;


    @Test
    public void mainPSelectAllTest() {
        assertThat(mainMapper.mainPSelectAll()).hasSize(1);
    }

    @Test
    public void mainDSelectAllTest() {
        assertThat(mainMapper.mainDSelectAll()).hasSize(1);
    }


    @Test
    public void mainCSelectAllTest() {
        assertThat(mainMapper.mainCSelectAll()).hasSize(1);
    }




    }