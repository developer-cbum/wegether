package com.wegether.app.dao.data;

import com.wegether.app.dao.DataDAO;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class DataDAOTests {

    @Autowired
    private DataDAO dataDAO;

    @Test
    public void selectmydata(){
        Assertions.assertThat(dataDAO.showmydata(1L)).hasSize(1);
    }



    // 자료 등록
//    @Test
//    public void saveConsultingTest(){
//        ConsultingVO consultingVO = new ConsultingVO();
//        consultingVO.setMemberId(1L);
//        consultingVO.setConsultingTitle("연세대가고싶어요");
//        consultingVO.setConsultingContent("어떻게하죠?");
//        consultingVO.setConsultingCategory("입시");
//        consultingDAO.saveConsulting(consultingVO);
//    }

    //자료 목록
//    @Test
//    public void findConsultingAllTest(){
//        Pagination pagination = new Pagination();
//        pagination.setPage(1);
//        pagination.progress();
//        List<ConsultingDTO> consultingDTOS = consultingDAO.findAll(pagination);
//        consultingDTOS.stream().map(consultingDTO -> consultingDTO.toString()).forEach(log::info);
//
//    }

    //총 개수
//    @Test
//    public void selectCountOfConsultingTests(){
//        int total = consultingDAO.findCountOfConsulting();
//        log.info(String.valueOf(total));
//    }


}
