package com.wegether.app.service.main;

import com.wegether.app.domain.dto.*;

import java.util.List;

public interface MainService {

    public List<MainDTO> mainPGetList();

    public List<MainDTO> mainCGetList();

    public List<MainDTO> mainDGetList();

    public List<MainDTO> mainDRGetList();

    public List<MainDTO> mainSPGetList(MainProjectPagination mainProjectPagination, Search search);

    public List<MainDTO> mainSDGetList(MainDataPagination maindataPagination, Search search);

    public int getProjectTotal(Search search);

    public int getDataTotal(Search search);
}




















