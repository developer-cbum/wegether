package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CardDTO;
import com.wegether.app.domain.vo.CardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardMapper {

//    카드 등록
    public void insert(CardVO cardVO);

//    카드 삭제
    public void delete(Long id);

//    카드 목록
    public List<CardDTO> selectAll(Long memberId);

}
