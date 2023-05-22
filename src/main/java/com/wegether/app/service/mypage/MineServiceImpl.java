package com.wegether.app.service.mypage;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.dao.DataDAO;
import com.wegether.app.dao.MemberDAO;
import com.wegether.app.dao.ProjectDAO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.MemberDTO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MineServiceImpl implements MypageService {

    private final MemberDAO memberDAO;
    private final DataDAO dataDAO;
    private final ConsultingDAO consultingDAO;
    private final ProjectDAO projectDAO;

    @Override
    public void mypage() {
        log.info("내 참여 다 조회");
    }


//    마이페이지 메인
    public Optional<MemberDTO> loadMine(Long id){
        return memberDAO.showmypage(id);
    }


    //    내가 등록한 자료 조회
    public List<DataDTO> readMine(Long memberId) {
        return dataDAO.showmydata(memberId);
    }


//    내 상담 조회



    public List<ConsultingVO> readMyConsulting(Long memberId){
        return consultingDAO.getmyconsult(memberId);
    }

// 내 프로젝트 조회

    public List<ProjectDTO> readMyProject(Long memberId){return projectDAO.showmyProject(memberId);}

}
