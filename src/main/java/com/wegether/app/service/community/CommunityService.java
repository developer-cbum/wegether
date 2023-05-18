package com.wegether.app.service.community;

import com.wegether.app.domain.vo.CommunityVO;

import java.util.Optional;

public interface CommunityService {

    public Optional<CommunityVO> getCommunity(Long id);

    public void write(CommunityVO communityVO);
}




















