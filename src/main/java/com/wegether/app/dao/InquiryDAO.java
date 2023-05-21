package com.wegether.app.dao;

import com.wegether.app.domain.dto.InquiryDTO;
import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {


    private final InquiryMapper inquiryMapper;

    //  문의 등록
    public void save(InquiryVO inquiryVO){
        inquiryMapper.insert(inquiryVO);
    }

//    문의 조회
    public List<InquiryDTO> findAll(Long memberId){
        return inquiryMapper.selectAll(memberId);
    }
}
