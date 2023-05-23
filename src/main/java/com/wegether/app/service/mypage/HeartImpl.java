package com.wegether.app.service.mypage;

import com.wegether.app.dao.WishProjectDAO;
import com.wegether.app.domain.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HeartImpl implements MypageService{

    private final WishProjectDAO wishProjectDAO;

    @Override
    public void mypage() {
        log.info("찜");
    }

    public List<ProjectDTO> projectHeart(Long memberId){
        return wishProjectDAO.showwish(memberId);
    }
}
