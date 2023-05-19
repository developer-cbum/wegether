package com.wegether.app.service.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.domain.vo.CommunityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityDAO communityDAO;

    @Override
    public List<CommunityVO> getList() { return communityDAO.findAll(); }

    @Override
    public Optional<CommunityVO> getCommunity(Long id) { return communityDAO.findById(id);}

    @Override
    public void write(CommunityVO communityVO) { communityDAO.save(communityVO);}

    @Override
    public void modify(CommunityVO communityVO) { communityDAO.setCommunityVO(communityVO); }

    @Override
    public void remove(Long id) { communityDAO.delete(id); }
}
