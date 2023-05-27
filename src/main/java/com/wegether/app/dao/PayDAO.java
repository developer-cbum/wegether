package com.wegether.app.dao;

import com.wegether.app.mapper.DataMapper;
import com.wegether.app.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PayDAO {
    private final PayMapper payMapper;

    //  결제 완료 insert
    public void savePay(Long memberId, Long dataId) {payMapper.insertPay(memberId, dataId);}


}
