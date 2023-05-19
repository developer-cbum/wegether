package com.wegether.app.service.mypage;

import com.wegether.app.dao.CardDAO;
import com.wegether.app.domain.vo.CardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final CardDAO cardDAO;

    @Override
    public void register(CardVO cardVO) {
        cardDAO.save(cardVO);
    }

    @Override
    public void withdraw(Long id) {
        cardDAO.remove(id);
    }

}
