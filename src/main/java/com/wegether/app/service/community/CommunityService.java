package com.wegether.app.service.community;

import com.wegether.app.domain.vo.CommunityVO;

import java.util.List;
import java.util.Optional;

public interface CommunityService {

    public List<CommunityVO> getList();

    public Optional<CommunityVO> getCommunity(Long id);

    public void write(CommunityVO communityVO);

    public void modify(CommunityVO communityVO);

    public void remove(Long id);
}




















