package com.wegether.app.mapper.wishProject;

import com.wegether.app.domain.vo.WishProjectVO;
import com.wegether.app.mapper.WishProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@Slf4j
public class WishProjectMapperTests {

    @Autowired
    private WishProjectMapper wishProjectMapper;

    @Test
    public void insertTest(){
        WishProjectVO wishProjectVO=new WishProjectVO();
        wishProjectVO.setMemberId(1L);
        wishProjectVO.setProjectId(1L);
        wishProjectMapper.insert(wishProjectVO);
    }

    @Test
    public void deleteTest(){
        wishProjectMapper.delete(2L);
    }
}
