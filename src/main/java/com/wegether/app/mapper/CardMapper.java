package com.wegether.app.mapper;

import com.wegether.app.domain.vo.CardVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardMapper {

//    카드 등록
    public void insert(CardVO cardVO);
//    카드 삭제
    public void delete(Long id);

}
