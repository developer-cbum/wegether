package com.wegether.app.mapper;

import com.wegether.app.domain.vo.PayVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {

    //  결제 완료 insert
    public void insertPay(PayVO payVO);

    //  결제 완료 member update
    public void updateMemberPoint(Long memberId, Long payPointUse);
}
