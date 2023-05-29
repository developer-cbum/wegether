package com.wegether.app.service.main;

import com.wegether.app.dao.MainDAO;
import com.wegether.app.dao.MainFileDAO;
import com.wegether.app.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MainDTO> mainSPGetList(MainProjectPagination mainProjectPagination, Search search) {
//        총 갯수 넣기
        mainProjectPagination.setTotal(mainDAO.findCountOfProject(search));
        mainProjectPagination.progress();
//        게시글 전체 목록
        final List<MainDTO> mainDTOS = mainDAO.mainSPFindAll(mainProjectPagination, search);
//        게시글 하나씩 첨부파일 목록 담기
        mainDTOS.forEach(mainDTO -> mainDTO.setFiles(mainFileDAO.mainPFFindAll(mainDTO.getId())));
        return mainDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<MainDTO> mainSDGetList(MainDataPagination mainDataPagination, Search search) {
//        총 갯수 넣기
        mainDataPagination.setTotal(mainDAO.findCountOfData(search));
        mainDataPagination.progress();
//        게시글 전체 목록
        final List<MainDTO> mainDTOS = mainDAO.mainSDFindAll(mainDataPagination, search);
//        게시글 하나씩 첨부파일 목록 담기
        mainDTOS.forEach(mainDTO -> mainDTO.setFiles(mainFileDAO.mainDFFindAll(mainDTO.getId())));
        return mainDTOS;
    }


//
    @Override
     public int getDataTotal(Search search){return mainDAO.findCountOfData(search);}

    @Override
     public int getProjectTotal(Search search){return mainDAO.findCountOfProject(search);}



}




