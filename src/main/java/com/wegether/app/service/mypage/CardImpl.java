package com.wegether.app.service.mypage;

import com.wegether.app.dao.CardDAO;
import com.wegether.app.domain.vo.CardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class CardImpl implements MypageService {
    private final CardDAO cardDAO;


    @Override
    public void mypage() {
        log.info("cardImpl");
    }

    //    카드 등록
    public void register(CardVO cardVO) {
        cardDAO.save(cardVO);
    }

    //    카드 삭제
    public void withdraw(Long id) {
        cardDAO.remove(id);
    }

}