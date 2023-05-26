package com.wegether.app.dao;

import com.wegether.app.mapper.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PointDAO {

    private final PointMapper pointMapper;

    // 회원가입 포인트 2000원증정
    public void saveJoinPoint(Long memberId){
        pointMapper.insertJoinPoint(memberId);
    }

}
