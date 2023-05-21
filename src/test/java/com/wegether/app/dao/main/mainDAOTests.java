package com.wegether.app.dao.main;


import com.wegether.app.dao.MainDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest
public class mainDAOTests {



    @Autowired
    private MainDAO mainDAO;

    /* ------------------------------------------------------------------------------------ */

    //    공지사항 목록 테스트
    @Test
    public void mainPFindAllTest() {
        assertThat(mainDAO.mainPFindAll()).hasSize(1);
    }

    @Test
    public void mainCFindAllTest() {
        assertThat(mainDAO.mainCFindAll()).hasSize(1);
    }

    @Test
    public void mainDFindAllTest() {
        assertThat(mainDAO.mainDFindAll()).hasSize(1);
    }









}
