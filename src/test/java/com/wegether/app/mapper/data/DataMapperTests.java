package com.wegether.app.mapper.data;

import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.mapper.DataMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        dataDTO.setId(1L);
        dataDTO.setDataTitle("테스트 제목1");
        dataDTO.setDataContent("테스트 내용1");
        dataDTO.setDataPrice(20000L);
        dataDTO.setDataSchool("서울대학교");
        dataDTO.setDataMajor("컴퓨터공학과");
        dataDTO.setMemberId(1L);
        dataMapper.insert(dataDTO);
    }

        @Test
        public void selectAllTest(){
            Pagination pagination = new Pagination();
            pagination.setPage(1); //화면에서 전달받은 페이지
//        assertThat(dataMapper.selectAll(pagination)).hasSize(2);
//        postMapper.selectAll(pagination, new Search("popular")).stream().map(PostDTO::toString).forEach(log::info);
//        postMapper.selectAll(pagination, new Search()).stream().map(PostDTO::toString).forEach(log::info);
        }

        @Test
        public void selectTest(){
            dataMapper.select(1L).stream().map(DataDTO::toString).forEach(log::info);
            dataMapper.select(1L).stream().map(DataDTO::getMemberNickname).forEach(log::info);
//            dataMapper.select(1L).stream().map(DataDTO::getWishDataId).forEach(log::info);


    }



//    소영 마이페이지
//    내가 등록한 자료 조회 test
    @Test
    public void selectmydataTest(){
        assertThat(dataMapper.selectmydata(1L)).hasSize(1);
//        dataMapper.selectmydata(1L).map(DataVO::getMemberId).ifPresent(log::info);
    }
    
}
