package com.wegether.app.service.main;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.NoticeVO;

import java.util.List;
import java.util.Optional;

public interface MainService {

    public List<MainDTO> mainPGetList();

    public List<MainDTO> mainCGetList();

    public List<MainDTO> mainDGetList();

    public List<MainDTO> mainDRGetList();

    public List<MainDTO> mainSPGetList(MainPagination mainPagination);

    public List<MainDTO> mainSDGetList(MainPagination mainPagination);

    public int getTotal();
}




















