package com.wegether.app.dao.card;


import com.wegether.app.dao.CardDAO;
import com.wegether.app.domain.vo.CardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CardDAOTests {
    @Autowired
    private CardDAO cardDAO;

    @Test
    public void saveTest() {
        CardVO cardVO = new CardVO();
        cardVO.setMemberId(1L);
        cardVO.setCardNumber("1234567812345678");
        cardVO.setCardBirthDate("2506");
        cardVO.setCardPassword("12");

        cardDAO.save(cardVO);
    }

    @Test
    public void removeTest(){
        cardDAO.remove(2L);
    }

}
