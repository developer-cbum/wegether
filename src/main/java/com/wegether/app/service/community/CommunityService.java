package com.wegether.app.service.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.vo.CommunityVO;

import java.util.List;
import java.util.Optional;

public interface CommunityService {

    public List<CommunityDTO> getList(CommunityPagination communityPagination);

    public Optional<CommunityDTO> getCommunity(Long id);

    public void write(CommunityDTO communityDTO);

    public void modify(CommunityDTO communityDTO);

    public void remove(Long id);
}




















