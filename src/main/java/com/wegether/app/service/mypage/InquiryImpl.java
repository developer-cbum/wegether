package com.wegether.app.service.mypage;


import com.wegether.app.dao.InquiryDAO;
import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.dto.InquiryDTO;
import com.wegether.app.domain.vo.DataFileVO;
import com.wegether.app.domain.vo.InquiryVO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InquiryImpl implements MypageService{
    private final InquiryDAO inquiryDAO;

    @Override
    public void mypage() {
        log.info("문의");
    }




    //    문의 등록
    public void register(InquiryVO inquiryVO) {
        inquiryDAO.save(inquiryVO);
    }
//    문의 답변 리스트
    public List<InquiryDTO> read(Long memberId){
        return inquiryDAO.findAll(memberId);
    }
}
