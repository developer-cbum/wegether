package com.wegether.app.dao;

import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {

    private final FileMapper fileMapper;

    public List<CommunityFileDTO> findAll(Long communityId) { return fileMapper.selectAll(communityId); }

    public void save(CommunityFileDTO communityFileDTO) { fileMapper.insert(communityFileDTO);}

}
