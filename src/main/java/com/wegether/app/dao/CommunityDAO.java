package com.wegether.app.dao;

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

    public List<CommunityVO> findAll() { return communityMapper.selectAll(); }

    public Optional<CommunityVO> findById(Long id){ return communityMapper.select(id);}

    public void save(CommunityVO communityVO){communityMapper.insert(communityVO);}

    public void setCommunityVO(CommunityVO communityVO){communityMapper.update(communityVO);}

    public void delete(Long id){communityMapper.delete(id);}
}

