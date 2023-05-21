package com.wegether.app.service.mypage;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.dao.DataDAO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MineServiceImpl implements MypageService {

    private final DataDAO dataDAO;

    @Override
    public void mypage() {
        log.info("내 참여 다 조회");
    }

    //    내가 등록한 자료 조회
    public List<DataDTO> readMine(Long memberId) {
        return dataDAO.showmydata(memberId);
    }


//    내 상담 조회

    private final ConsultingDAO consultingDAO;

    public List<ConsultingVO> readMyConsulting(Long memberId){
        return consultingDAO.getmyconsult(memberId);
    }
}
