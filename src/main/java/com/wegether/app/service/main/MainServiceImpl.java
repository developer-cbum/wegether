package com.wegether.app.service.main;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.dao.MainDAO;
import com.wegether.app.dao.MainFileDAO;
import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainFileDTO;
import com.wegether.app.domain.vo.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final MainDAO mainDAO;
    private final MainFileDAO mainFileDAO;

//    @Override
//    public List<MainDTO> mainPGetList() { return mainDAO.mainPFindAll(); }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MainDTO> mainPGetList() {
//        게시글 전체 목록
        final List<MainDTO> mainDTOS = mainDAO.mainPFindAll();
//        게시글 하나씩 첨부파일 목록 담기
        mainDTOS.forEach(mainDTO -> mainDTO.setFiles(mainFileDAO.mainPFFindAll(mainDTO.getId())));
        return mainDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MainDTO> mainDGetList() {
//        게시글 전체 목록
        final List<MainDTO> mainDTOS = mainDAO.mainDFindAll();
//        게시글 하나씩 첨부파일 목록 담기
        mainDTOS.forEach(mainDTO -> mainDTO.setFiles(mainFileDAO.mainDFFindAll(mainDTO.getId())));
        return mainDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MainDTO> mainCGetList() {
//        게시글 전체 목록
        final List<MainDTO> mainDTOS = mainDAO.mainCFindAll();
//        게시글 하나씩 첨부파일 목록 담기
        mainDTOS.forEach(mainDTO -> mainDTO.setFiles(mainFileDAO.mainCFFindAll(mainDTO.getId())));
        return mainDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MainDTO> mainDRGetList() {
//        게시글 전체 목록
        final List<MainDTO> mainDTOS = mainDAO.mainDRFindAll();
//        게시글 하나씩 첨부파일 목록 담기
        mainDTOS.forEach(mainDTO -> mainDTO.setFiles(mainFileDAO.mainDRFindAll(mainDTO.getId())));
        return mainDTOS;
    }

}



