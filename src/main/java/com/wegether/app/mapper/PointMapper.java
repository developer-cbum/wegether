package com.wegether.app.mapper;

import com.wegether.app.domain.dto.MemberDTO;
import com.wegether.app.domain.dto.PointDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PointMapper {

    // 회원가입 포인트 2000원증정
    public void insertJoinPoint(Long memberId);

    // 포인트 내역
    public List<PointDTO> selectMyPoint(Long id);

}
