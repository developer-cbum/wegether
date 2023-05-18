package com.wegether.app.dao;

import com.wegether.app.domain.vo.CommunityVO;
import com.wegether.app.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommunityDAO {

    private final CommunityMapper communityMapper;

    public Optional<CommunityVO> findById(Long id){ return communityMapper.select(id);}

    public void save(CommunityVO communityVO){communityMapper.insert(communityVO);}
}

