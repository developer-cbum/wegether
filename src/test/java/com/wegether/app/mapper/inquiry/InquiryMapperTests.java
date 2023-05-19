package com.wegether.app.mapper.inquiry;

import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.mapper.InquiryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InquiryMapperTests {
    @Autowired
    private InquiryMapper inquiryMapper;

    @Test
    public void insertTest(){
        InquiryVO inquiryVO = new InquiryVO();
        inquiryVO.setMemberId(1L);
        inquiryVO.setInquiryTitle("모의고사 공부법");
        inquiryVO.setInquiryContent("영어 등급 어떻게 올려요?");
        inquiryMapper.insert(inquiryVO);
    }

}
