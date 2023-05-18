package com.wegether.app.mapper;

import com.wegether.app.domain.vo.CommunityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CommunityMapper {

    public Optional<CommunityVO> select(Long id);
}
