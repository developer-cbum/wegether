package com.wegether.app.dao;


import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainDataPagination;
import com.wegether.app.domain.dto.MainProjectPagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MainDAO {
    private final MainMapper mainMapper;

    // 공지사항 목록
    public List<MainDTO> mainPFindAll(){
        return mainMapper.mainPSelectAll();
    };

    public List<MainDTO> mainDFindAll(){
        return mainMapper.mainDSelectAll();
    };

    public List<MainDTO> mainCFindAll(){ return mainMapper.mainCSelectAll(); };

    public List<MainDTO> mainDRFindAll(){ return mainMapper.mainDRSelectAll();};

    // 프로젝트 전체 목록
    public List<MainDTO> mainSPFindAll(MainProjectPagination mainProjectPagination, Search search)
    { return mainMapper.searchPSelectAll(mainProjectPagination, search);};

    // 프로젝트 총 갯수
    public int findCountOfProject(Search search){return mainMapper.selectCountOfProject(search); }

//    자료실 전체 목록
    public List<MainDTO> mainSDFindAll(MainDataPagination mainDataPagination, Search search)
    { return mainMapper.searchDSelectAll(mainDataPagination, search);};

//    자료실 총 갯수
    public int findCountOfData(Search search){return mainMapper.selectCountOfData(search);}

}

