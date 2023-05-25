package com.wegether.app.dao;


import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainPagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.NoticeVO;
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
    public List<MainDTO> mainSPFindAll(MainPagination mainPagination){ return mainMapper.searchPSelectAll(mainPagination);};

    // 프로젝트 총 갯수
    public int findCountOfProject(){return mainMapper.selectCountOfProject(); }

//    자료실 전체 목록
    public List<MainDTO> mainSDFindAll(MainPagination mainPagination) { return mainMapper.searchDSelectAll(mainPagination);};

//    자료실 총 갯수
    public int findCountOfData(){return mainMapper.selectCountOfData();}

}

