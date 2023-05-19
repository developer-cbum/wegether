package com.wegether.app.dao;

import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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


}
