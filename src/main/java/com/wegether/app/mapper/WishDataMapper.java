package com.wegether.app.mapper;

import com.wegether.app.domain.vo.WishDataVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WishDataMapper {
    //    찜하기
    public void insert(WishDataVO wishDataVO);
    //    찜삭제
    public void delete(Long id);
}
