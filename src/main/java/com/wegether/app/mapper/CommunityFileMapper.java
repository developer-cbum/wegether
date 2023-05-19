package com.wegether.app.mapper;

import com.wegether.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityFileMapper {

    public void insert(FileVO fileVO);

    public List<FileVO> selectAll(Long communityId);

    public void delete(Long id);

    public void deleteAll(Long communityId);
}
