package com.wegether.app.dao.inquiry;

import com.wegether.app.dao.InquiryDAO;
import com.wegether.app.domain.vo.InquiryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InquiryDAOTests {
    @Autowired
    private InquiryDAO inquiryDAO;

    @Test
    public void saveTest(){
        InquiryVO inquiryVO = new InquiryVO();
        inquiryVO.setMemberId(1L);
        inquiryVO.setInquiryTitle("프로젝트 기간 설정");
        inquiryVO.setInquiryContent("프로젝트 기간을 바꾸고 싶어요! 어떻게 해야하죠 ?");
        inquiryDAO.save(inquiryVO);
    }

}
