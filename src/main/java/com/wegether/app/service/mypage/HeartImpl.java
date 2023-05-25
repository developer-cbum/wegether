package com.wegether.app.service.mypage;

import com.wegether.app.dao.WishDataDAO;
import com.wegether.app.dao.WishProjectDAO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.HeartDTO;
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


//    전체 찜
    public List<HeartDTO> allHearts(Long memberId){
        return wishProjectDAO.showAllHearts(memberId);
    }



    @Override
    public void mypage() {
        log.info("찜");
    }

    public List<ProjectDTO> projectHeart(Long memberId){
        return wishProjectDAO.showwish(memberId);
    }

//    ====================================================================================================


    private final WishDataDAO wishDataDAO;

    public List<DataDTO> dataHeart(Long memberId){
        return wishDataDAO.showwishData(memberId);
    }

}
