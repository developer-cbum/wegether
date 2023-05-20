package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.vo.CommunityFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityFileMapper {

    public void insert(CommunityFileDTO fileVO);

    public List<CommunityFileDTO> selectAll(Long communityId);

    public void delete(Long id);

    public void deleteAll(Long communityId);
}
