package com.wegether.app.service.mypage;

import com.wegether.app.dao.CardDAO;
import com.wegether.app.domain.dto.CardDTO;
import com.wegether.app.domain.vo.CardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class CardImpl implements MypageService {
    private final CardDAO cardDAO;


    @Override
    public void mypage() {
        log.info("카드");
    }

    //    카드 등록
    public void register(CardVO cardVO) {
        cardDAO.save(cardVO);
    }


    //    카드 목록
    public List<CardDTO> getList(Long memberId){
        return cardDAO.list(memberId);
    }

    //    카드 삭제
    public void remove(Long id) {
        cardDAO.remove(id);
    }

}