package com.wegether.app.service.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.domain.dto.CommunityDTO;
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
    public List<CommunityDTO> getList() { return communityDAO.findAll(); }

    @Override
    public Optional<CommunityDTO> getCommunity(Long id) { return communityDAO.findById(id);}

    @Override
    public void write(CommunityDTO communityDTO) { communityDAO.save(communityDTO);}

    @Override
    public void modify(CommunityDTO communityDTO) { communityDAO.setCommunityDTO(communityDTO); }

    @Override
    public void remove(Long id) { communityDAO.delete(id); }
}
