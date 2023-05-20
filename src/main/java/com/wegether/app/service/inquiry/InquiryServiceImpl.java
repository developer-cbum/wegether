package com.wegether.app.service.inquiry;

import com.wegether.app.dao.InquiryDAO;
import com.wegether.app.domain.vo.InquiryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("inquiry")
public class InquiryServiceImpl implements InquiryService{
    private final InquiryDAO inquiryDAO;

    @Override
    public void register(InquiryVO inquiryVO) {
        inquiryDAO.save(inquiryVO);
    }
}
