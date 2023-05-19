package com.wegether.app.mapper;

import com.wegether.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityFileMapper {

    public void insert(FileVO fileVO);

    public FileVO selectAll();

    public void delete();

    public void deleteAll();
}
