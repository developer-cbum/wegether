package com.wegether.app.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {

    // 회원가입 포인트 2000원증정
    public void insertJoinPoint(Long memberId);
}
