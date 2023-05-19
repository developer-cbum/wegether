package com.wegether.app.dao.data;

import com.wegether.app.dao.DataDAO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class DataDAOTests {

    @Autowired
    private DataDAO dataDAO;

    @Test
    public void selectmydata(){
        Assertions.assertThat(dataDAO.showmydata(1L)).hasSize(1);
    }
    
}
