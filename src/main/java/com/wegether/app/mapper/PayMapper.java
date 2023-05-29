package com.wegether.app.mapper;

import com.wegether.app.domain.vo.PayVO;
import com.wegether.app.domain.vo.PointVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {

    //  결제 완료 insert
    public void insertPay(PayVO payVO);

    //  결제 완료 member update
    public void updateMemberPoint(Long memberId, Long payPointUse);

    //  결제 완료 insert point
//    적립
    public void insertPoint(PointVO pointVO);

//    사용
    public void insertPayPoint(PointVO pointVO);
}
