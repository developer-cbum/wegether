package com.wegether.app.service.main;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainFileDTO;
import com.wegether.app.domain.vo.NoticeVO;

import java.util.List;
import java.util.Optional;

public interface MainService {

    public List<MainDTO> mainPGetList();

    public List<MainDTO> mainCGetList();

    public List<MainDTO> mainDGetList();

    public List<MainDTO> mainDRGetList();


}




















