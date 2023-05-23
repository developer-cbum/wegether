package com.wegether.app.dao;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.WishProjectVO;
import com.wegether.app.mapper.WishProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WishProjectDAO {
    private final WishProjectMapper wishProjectMapper;

    //    찜하기
    public void pushwish(WishProjectVO wishProjectVO){
        wishProjectMapper.insert(wishProjectVO);
    };
    //    찜삭제
    public void undowish(Long id){
        wishProjectMapper.delete(id);
    }

    //  찜 조회
    public List<ProjectDTO> showwish(Long memberId){
        return wishProjectMapper.selectAll(memberId);
    }


}
