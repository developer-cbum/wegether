package com.wegether.app.dao.data;

import com.wegether.app.dao.DataDAO;
import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
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
    @Test
    public void saveDataTest(){
        DataDTO dataDTO = new DataDTO();
        dataDTO.setId(4L);
        dataDTO.setDataId(2L);
        dataDTO.setDataTitle("내 자료 팜");
        dataDTO.setDataContent("얼마에 살래");
        dataDTO.setDataMajor("디자인학과");
        dataDTO.setDataSchool("홍익대");
        dataDTO.setDataPrice(10000000L);
        dataDAO.save(dataDTO);
    }


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
