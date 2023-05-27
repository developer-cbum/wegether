package com.wegether.app.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {

    //  결제 완료 insert
    public void insertPay(Long memberId, Long dataId);
}
