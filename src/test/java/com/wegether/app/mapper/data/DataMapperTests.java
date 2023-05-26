package com.wegether.app.mapper.data;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.mapper.DataMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class DataMapperTests {

    @Autowired
    private DataMapper dataMapper;

    //    자료 등록 테스트
    @Test
    public void insertTest() {
        DataDTO dataDTO = new DataDTO();

        dataDTO.setId(4L);
        dataDTO.setDataTitle("자료 팜");
        dataDTO.setDataContent("내 자료 팔아요");
        dataDTO.setDataPrice(20000L);
        dataDTO.setDataSchool("홍익대");
        dataDTO.setDataMajor("디자인과");
        dataDTO.setMemberId(2L);
        dataMapper.insert(dataDTO);

    }

//    자료 목록
//    @Test
//    public void selectAllTest(){
//        DataPagination dataPagination = new DataPagination();
//        dataPagination.setPage(1);
//        dataPagination.progress();
//        List<DataDTO> dataDTOS = dataMapper.selectAll(dataPagination);
//        dataDTOS.stream().map(dataDTO -> dataDTO.toString()).forEach(log::info);
//    }

//        @Test
//        public void selectTest(){
//            dataMapper.select(1L).stream().map(DataDTO::toString).forEach(log::info);
////            dataMapper.select(1L).stream().map(DataDTO::getMemberNickname).forEach(log::info);
////            dataMapper.select(1L).stream().map(DataDTO::getWishDataId).forEach(log::info);
//
//
//    }



//    소영 마이페이지
//    내가 등록한 자료 조회 test
    @Test
    public void selectmydataTest(){
        assertThat(dataMapper.selectmydata(1L)).hasSize(1);
//        dataMapper.selectmydata(1L).map(DataVO::getMemberId).ifPresent(log::info);
    }
    
}
