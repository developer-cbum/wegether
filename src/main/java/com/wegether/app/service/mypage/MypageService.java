package com.wegether.app.service.mypage;

import com.wegether.app.domain.vo.CardVO;

public interface MypageService {
    //    카드 등록
    public void register(CardVO cardVO);
    //    카드 삭제
    public void withdraw(Long id);
}




















