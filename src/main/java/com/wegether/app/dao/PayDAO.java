package com.wegether.app.dao;

import com.wegether.app.domain.vo.PayVO;
import com.wegether.app.mapper.DataMapper;
import com.wegether.app.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PayDAO {
    private final PayMapper payMapper;

    //  결제 완료 insert
    public void savePay(PayVO payVO) {payMapper.insertPay(payVO);}

    //  결제 완료 memberPoint
    public void updatePoint(Long memberId, Long payPointUse) {payMapper.updateMemberPoint(memberId, payPointUse); }


}
