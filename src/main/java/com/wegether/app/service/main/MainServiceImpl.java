package com.wegether.app.service.main;

import com.wegether.app.dao.AdminDAO;
import com.wegether.app.dao.MainDAO;
import com.wegether.app.domain.dto.CommunityDTO;
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

    @Override
    public List<MainDTO> mainPGetList() { return mainDAO.mainPFindAll(); }

    @Override
    public List<MainDTO> mainCGetList() { return mainDAO.mainCFindAll(); }

    @Override
    public List<MainDTO> mainDGetList() { return mainDAO.mainDFindAll(); }


   


}
