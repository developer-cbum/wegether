package com.wegether.app.service.mypage;

import com.wegether.app.dao.PointDAO;
import com.wegether.app.domain.dto.PointDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PointImpl implements MypageService{


    private final PointDAO pointDAO;

    @Override
    public void mypage() {
        log.info("포인트 서비스");
    }

    public List<PointDTO> getPoints (Long memberId) {
        return pointDAO.getMyPoint(memberId) ;
    }

}
