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

    public List<CommunityFileDTO> communityFindAll(Long communityId) { return fileMapper.communitySelectAll(communityId); }

    public void communitySave(CommunityFileDTO communityFileDTO) { fileMapper.communityInsert(communityFileDTO);}

    public void communityDelete(Long id){ fileMapper.communityDelete(id);}

    public void communityDeleteAll(Long communityId) { fileMapper.communityDeleteAll(communityId);}
}
