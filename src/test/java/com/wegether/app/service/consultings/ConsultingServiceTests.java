package com.wegether.app.service.consultings;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.service.consult.ConsultService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class ConsultingServiceTests {

//    @Autowired
//    private ConsultService consultService;
//
//    // 상담 등록
//    @Test
//    public void saveConsultingTest(){
//        ConsultingVO consultingVO = new ConsultingVO();
//        consultingVO.setMemberId(1L);
//        consultingVO.setConsultingTitle("연세대가고싶어요");
//        consultingVO.setConsultingContent("어떻게하죠?");
//        consultingVO.setConsultingCategory("입시");
//        consultService.register(consultingVO);
//    }
//
//    //상담 목록
//    @Test
//    public void findConsultingAllTest(){
//        Pagination pagination = new Pagination();
//        Search search = new Search();
//        pagination.setPage(1);
//        pagination.progress();
//        List<ConsultingDTO> consultingDTOS = consultService.getList(pagination, search);
//        consultingDTOS.stream().map(consultingDTO -> consultingDTO.toString()).forEach(log::info);
//
//    }
//
//    //총 개수
//    @Test
//    public void getTotalTests(){
//        Search search = new Search();
//        int total = consultService.getTotal(search);
//        log.info(String.valueOf(total));
//    }
//
//    //상담 상세
//    @Test
//    public void getConsultTest(){
//        log.info(consultService.getConsulting(90L).toString());
//    }
//
//    //상담 수정
//    @Test
//    public void modifyTest(){
//        Optional<ConsultingDTO> consulting = consultService.getConsulting(1L);
//        consulting.get().setConsultingTitle("안녕2");
//        consultService.modifyConsulting( consulting.get());
//        log.info( consulting.get().toString());
//    }

}
