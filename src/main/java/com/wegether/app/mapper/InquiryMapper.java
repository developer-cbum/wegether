package com.wegether.app.mapper;

import com.wegether.app.domain.vo.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {
//    문의 등록
    public void insert(InquiryVO inquiryVO);

//    문의 조회
//    public void selectALL(Inquiry)

}
