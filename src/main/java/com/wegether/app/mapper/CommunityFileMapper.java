package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.vo.CommunityFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityFileMapper {
    public void insert(CommunityFileVO communityFileVO);

    public void delete(Long communityId);
}
