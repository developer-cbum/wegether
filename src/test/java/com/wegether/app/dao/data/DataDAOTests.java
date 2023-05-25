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
    public void showmydataTest(){
        Assertions.assertThat(dataDAO.showmydata(1L)).hasSize(1);
    }



    // 자료 등록
    @Test
    public void saveDataTest(){
        DataDTO dataDTO = new DataDTO();

        dataDTO.setId(7L);
        dataDTO.setDataId(2L);
        dataDTO.setDataTitle("자료 등록합니다");
        dataDTO.setDataContent("귀하다 귀해");
        dataDTO.setDataMajor("수학과");
        dataDTO.setDataSchool("연세대학교");
        dataDTO.setDataPrice(9999999L);
        dataDTO.setMemberId(2L);
        dataDAO.save(dataDTO);
    }


//    자료 목록
@Test
    public void findAllTest(){
        DataPagination dataPagination = new DataPagination();
        dataPagination.setPage(1);
        dataPagination.progress();
//        List<DataDTO> dataDTOS = dataDAO.findAll(dataPagination);
//        dataDTOS.stream().map(dataDTO -> dataDTO.toString()).forEach(log::info);

    }


    //총 개수
    @Test
    public void selectCountOfDataTests(){
        int total = dataDAO.findCountOfData();
        log.info(String.valueOf(total));
    }


}
