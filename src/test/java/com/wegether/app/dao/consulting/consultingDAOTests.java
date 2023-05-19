package com.wegether.app.dao.consulting;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class consultingDAOTests {

    @Autowired
    private ConsultingDAO consultingDAO;

    // 상담 등록
    @Test
    public void saveConsultingTest(){
        ConsultingVO consultingVO = new ConsultingVO();
        consultingVO.setMemberId(1L);
        consultingVO.setConsultingTitle("연세대가고싶어요");
        consultingVO.setConsultingContent("어떻게하죠?");
        consultingVO.setConsultingCategory("입시");
        consultingDAO.saveConsulting(consultingVO);
    }
}
