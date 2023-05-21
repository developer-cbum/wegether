package com.wegether.app.mapper;

import com.wegether.app.domain.dto.InquiryDTO;
import com.wegether.app.domain.vo.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {
//    문의 등록
    public void insert(InquiryVO inquiryVO);

//    문의 조회
    public List<InquiryDTO> selectAll(Long memberId);



}
