package com.wegether.app.service.main;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class MainServiceTests {

    @Autowired
    private MainService mainService;

    @Test
    public void mainPGetListTest(){
        assertThat(mainService.mainPGetList()).hasSize(1);
    };

    @Test
    public void mainCGetListTest(){
        assertThat(mainService.mainCGetList()).hasSize(1);
    };


    @Test
    public void mainDGetListTest(){
        assertThat(mainService.mainDGetList()).hasSize(1);
    };
}
