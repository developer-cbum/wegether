package com.wegether.app.dao.data;

import com.wegether.app.dao.DataDAO;
import com.wegether.app.domain.dto.*;
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

        dataDTO.setId(5L);
        dataDTO.setDataId(2L);
        dataDTO.setDataTitle("내 자료 팜");
        dataDTO.setDataContent("얼마에 살래");
        dataDTO.setDataMajor("디자인학과");
        dataDTO.setDataSchool("홍익대");
        dataDTO.setDataPrice(10000000L);
        dataDTO.setMemberId(2L);
        dataDAO.save(dataDTO);
    }


//    자료 목록
@Test
    public void findAllTest(){
        DataPagination dataPagination = new DataPagination();
        dataPagination.setPage(1);
        dataPagination.progress();
        List<DataDTO> dataDTOS = dataDAO.findAll(dataPagination);
        dataDTOS.stream().map(dataDTO -> dataDTO.toString()).forEach(log::info);

    }

    //총 개수
    @Test
    public void selectCountOfDataTests(){
        int total = dataDAO.findCountOfData();
        log.info(String.valueOf(total));
    }


}
