package com.wegether.app.dao;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.vo.CommunityVO;
import com.wegether.app.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommunityDAO {

    private final CommunityMapper communityMapper;

    public List<CommunityDTO> findAll(CommunityPagination communityPagination) { return communityMapper.selectAll(communityPagination); }

    public Optional<CommunityDTO> findById(Long id){ return communityMapper.select(id);}

    public void save(CommunityDTO communityDTO){communityMapper.insert(communityDTO);}

    public void setCommunityDTO(CommunityDTO communityDTO){communityMapper.update(communityDTO);}

    public void delete(Long id){communityMapper.delete(id);}

    public int findCountOfCommunity(CommunityPagination communityPagination) { return communityMapper.selectCountOfCommunity(communityPagination); }
}

