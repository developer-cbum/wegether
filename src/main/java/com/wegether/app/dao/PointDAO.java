package com.wegether.app.dao;

import com.wegether.app.domain.dto.MemberDTO;
import com.wegether.app.domain.dto.PointDTO;
import com.wegether.app.mapper.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PointDAO {

    private final PointMapper pointMapper;

    // 회원가입 포인트 2000원증정
    public void saveJoinPoint(Long memberId){
        pointMapper.insertJoinPoint(memberId);
    }

//    포인트 내역
    public List<PointDTO> getMyPoint(Long memberId){
        return pointMapper.selectPoint(memberId);
    }

}
