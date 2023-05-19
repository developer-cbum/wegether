package com.wegether.app.mapper.data;

import com.wegether.app.domain.dto.DataDTO;
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
    public void insertTest(){
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


    
}
