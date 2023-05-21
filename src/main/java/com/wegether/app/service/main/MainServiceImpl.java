package com.wegether.app.service.main;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.dao.MainDAO;
import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.vo.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final MainDAO mainDAO;

    @Override
    public List<MainDTO> mainPGetList() { return mainDAO.mainPFindAll(); }

    @Override
    public List<MainDTO> mainCGetList() { return mainDAO.mainCFindAll(); }

    @Override
    public List<MainDTO> mainDGetList() { return mainDAO.mainDFindAll(); }


}
