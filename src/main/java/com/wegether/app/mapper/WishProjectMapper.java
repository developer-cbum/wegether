package com.wegether.app.mapper;

import com.wegether.app.domain.vo.WishProjectVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WishProjectMapper {
//    찜하기
    public void insert(WishProjectVO wishProjectVO);
//    찜삭제
    public void delete(Long id);
}
