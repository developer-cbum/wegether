package com.wegether.app.dao;

import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.mapper.CommunityFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommunityFileDAO {

    private final CommunityFileMapper communityFileMapper;

    public void save(CommunityFileVO communityFileVO){communityFileMapper.insert(communityFileVO);}

    public void delete(Long communityId) {communityFileMapper.delete(communityId);}
}
