package com.wegether.app.service.mypage;

import com.wegether.app.dao.CardDAO;
import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.service.inquiry.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
@Slf4j
public class CardServiceTests {
    @Autowired
    private CardImpl card;

    @Test
    public void showTests() {

        Assertions.assertThat(card.getList(1L)).hasSize(6);

    }
    @Test 
    public void saveTests(){
        CardVO cardVO = new CardVO();
        cardVO.setMemberId(2L);
        cardVO.setCardNumber("1234567812345678");
        cardVO.setCardBirthDate("2506");
        cardVO.setCardPassword("12");

        card.register(cardVO);
    }

    @Test
    public void removeTest(){
       card.remove(2L);
    }
}
