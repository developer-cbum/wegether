package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CommunityFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    public void communityInsert(CommunityFileDTO fileVO);

    public List<CommunityFileDTO> communitySelectAll(Long communityId);

    public void communityDelete(Long id);

    public void communityDeleteAll(Long communityId);
}
