package com.wegether.app.mapper.consultings;

import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.mapper.ConsultingMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class consultingMapperTests {

    @Autowired
    private ConsultingMapper consultingMapper;

    // 컨설팅 등록
    @Test
    public void insertConsultingTest(){
        ConsultingVO consultingVO = new ConsultingVO();
        consultingVO.setId(1L);
        consultingVO.setMemberId(1L);
        consultingVO.setConsultingTitle("서울대가고싶어요");
        consultingVO.setConsultingContent("어떻게하죠?");
        consultingVO.setConsultingCategory("입시");

        consultingMapper.insertConsulting(consultingVO);
    }

}
