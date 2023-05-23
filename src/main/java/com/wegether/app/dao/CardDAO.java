package com.wegether.app.dao;

import com.wegether.app.domain.dto.CardDTO;
import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardDAO {

    private final CardMapper cardMapper;

    //    카드 등록
    public void save(CardVO cardVO){
        cardMapper.insert(cardVO);
    }

    //    카드 삭제
    public void remove(Long id){
        cardMapper.delete(id);
    }

    //    카드 목록
    public List<CardDTO> list(Long memberId){
        return cardMapper.selectAll(memberId);
    }
}
