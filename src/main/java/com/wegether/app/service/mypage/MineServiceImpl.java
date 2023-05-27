package com.wegether.app.service.mypage;

import com.wegether.app.dao.*;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.DataPagination;
import com.wegether.app.domain.dto.MemberDTO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final FileDAO fileDAO;

    @Override
    public void mypage() {
        log.info("내 참여 다 조회");
    }


//    마이페이지 메인
    public Optional<MemberDTO> loadMine(Long id){
        return memberDAO.showmypage(id);
    }

//    마이페이지 회원 탈퇴
    public void changeAccount(Long id){
        memberDAO.updateMemberS(id);
    }


    //    내가 등록한 자료 조회
    public List<DataDTO> readMine(Long memberId) {
        final List<DataDTO> datas = dataDAO.showmydata(memberId);
        //        게시글 하나씩 첨부파일 목록 담기
        datas.forEach(data -> data.setFiles(fileDAO.dataFindAll(data.getId())));
        return datas;
    }

//    기본 설정 변경
    public void modifyBasicSetting(Long id, String memberNickname, String memberPhoneNumber){
        memberDAO.setBasicSetting(id, memberNickname, memberPhoneNumber);
    }

    //    내 프로젝트 조회
//    public List<ProjectDTO> readMyProject(Long memberId) {
//
//        final List<ProjectDTO> projects = projectDAO.showmyProject(memberId);
//        //        게시글 하나씩 첨부파일 목록 담기
//        projects.forEach(project -> project.setFiles(fileDAO.dataFindAll(project.getId())));
//        return datas;
//        return projectDAO.showmyProject(memberId);
//    }



//
//    @Transactional(rollbackFor = Exception.class)
//    public List<DataDTO> getList(Long memberId) {
//        //        게시글 전체 목록
//        final List<DataDTO> datas = dataDAO.findAll(dataPagination);
//        //        게시글 하나씩 첨부파일 목록 담기
//        datas.forEach(data -> data.setFiles(fileDAO.dataFindAll(data.getId())));
//        return datas;
//    }






    public List<ConsultingVO> readMyConsulting(Long memberId){
        return consultingDAO.getmyconsult(memberId);
    }

// 내 프로젝트 조회

    //    내가 프로젝트 조회
    public List<ProjectDTO> readMyProject(Long memberId) {
        final List<ProjectDTO> projects = projectDAO.showmyProject(memberId);
        //        게시글 하나씩 첨부파일 목록 담기
//        projects.forEach(project -> project.setFiles(fileDAO.dataFindAll(project.getId())));
        return projects;
    }
//    public List<ProjectDTO> readMyProject(Long memberId){return projectDAO.showmyProject(memberId);}

}
