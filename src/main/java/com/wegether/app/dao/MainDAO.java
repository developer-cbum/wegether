package com.wegether.app.dao;


import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.Pagination;
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

    public List<MainDTO> mainSPFindAll(){ return mainMapper.searchPSelectAll();};
}

