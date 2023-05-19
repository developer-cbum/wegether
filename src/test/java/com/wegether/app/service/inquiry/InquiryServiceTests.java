package com.wegether.app.service.inquiry;

import com.wegether.app.domain.vo.InquiryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InquiryServiceTests {

    @Autowired
    private InquiryService inquiryService;

    @Test
    public void saveTests(){
        InquiryVO inquiryVO = new InquiryVO();
        inquiryVO.setMemberId(1L);
        inquiryVO.setInquiryTitle("안녕");
        inquiryVO.setInquiryContent("문의합니다");
        inquiryService.register(inquiryVO);
    }
}
