package com.wegether.app.mapper.card;

import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.mapper.CardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class CardMapperTests {
    @Autowired
    private CardMapper cardMapper;

    @Test
    public void insertTest() {
        CardVO cardVO = new CardVO();
        cardVO.setMemberId(1L);
        cardVO.setCardNumber("1234567812345678");
        cardVO.setCardBirthDate("2506");
        cardVO.setCardPassword("12");

        cardMapper.insert(cardVO);
    }

    @Test
    public void deleteTest(){
        cardMapper.delete(2L);
    }
}


