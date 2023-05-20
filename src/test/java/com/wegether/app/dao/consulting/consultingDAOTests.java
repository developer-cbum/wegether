package com.wegether.app.dao.consulting;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

    //상담 목록
    @Test
    public void findConsultingAllTest(){
        Pagination pagination = new Pagination();
        Search search = new Search();
        pagination.setPage(1);
        pagination.progress();
<<<<<<< HEAD
//        List<ConsultingDTO> consultingDTOS = consultingDAO.findAll(pagination);
//        consultingDTOS.stream().map(consultingDTO -> consultingDTO.toString()).forEach(log::info);
=======
        List<ConsultingDTO> consultingDTOS = consultingDAO.findAll(pagination, search);
        consultingDTOS.stream().map(consultingDTO -> consultingDTO.toString()).forEach(log::info);
>>>>>>> master

    }

    //총 개수
    @Test
    public void selectCountOfConsultingTests(){
<<<<<<< HEAD
//        int total = consultingDAO.findCountOfConsulting();
//        log.info(String.valueOf(total));
=======
        Search search = new Search();
        int total = consultingDAO.findCountOfConsulting(search);
        log.info(String.valueOf(total));
>>>>>>> master
    }

    //상담 상세
    @Test
    public void findConsultingTest(){
        log.info(consultingDAO.findConsulting(90L).toString());
    }

    //상담 수정
<<<<<<< HEAD
//    @Test
//    public void updateTest(){
//        ConsultingDTO consultingDTO = consultingDAO.findConsulting(1L);
//        consultingDTO.setConsultingTitle("안녕4");
//        consultingDAO.setConsulting(consultingDTO);
//        log.info(consultingDTO.toString());
//    }
=======
    @Test
    public void updateTest(){
        Optional<ConsultingDTO> consultingDTO = consultingDAO.findConsulting(1L);
        consultingDTO.get().setConsultingTitle("안녕4");
        consultingDAO.setConsulting(consultingDTO.get());
        log.info(consultingDTO.toString());
    }
>>>>>>> master
}
