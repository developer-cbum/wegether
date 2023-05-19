package com.wegether.app.dao.wish;

import com.wegether.app.dao.WishProjectDAO;
import com.wegether.app.domain.vo.WishProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class WishProjectDAOTests {
    @Autowired
    private WishProjectDAO wishProjectDAO;

    @Test
    public void pushwishTest(){
        WishProjectVO wishProjectVO=new WishProjectVO();
        wishProjectVO.setMemberId(1L);
        wishProjectVO.setProjectId(1L);
        wishProjectDAO.pushwish(wishProjectVO);
    }

    @Test
    public void deletewishTest(){
        wishProjectDAO.undowish(1L);
    }

    @Test
    public void showwishTest(){
        wishProjectDAO.showwish(1L);
    }
}
