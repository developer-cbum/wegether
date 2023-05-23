package com.wegether.app.dao.main;


import com.wegether.app.dao.MainFileDAO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.MainFileDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MainFileDAOTests {
    @Autowired
    private MainFileDAO mainFileDAO;

    @Test
    public void mainPFFindAllTest() {
        mainFileDAO.mainPFFindAll(1L).stream().map(MainFileDTO::toString).forEach(log::info);
    }


}
