package com.wegether.app.service.account;

import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.service.consult.ConsultService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ConsultingServiceTests {
    @Autowired
    private ConsultService consultService;

    @Test
    public void registerTest(){
        ConsultingVO consultingVO = new ConsultingVO();
        consultingVO.setMemberId(1L);
        consultingVO.setConsultingTitle("고려대가고싶어요");
        consultingVO.setConsultingContent("어떻게하죠?");
        consultingVO.setConsultingCategory("입시");
        consultService.register(consultingVO);
    }
}
