package com.wegether.app.service.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityReplyServiceImpl implements CommunityReplyService{

    private final CommunityReplyDAO communityReplyDAO;

    @Override
    public void register(CommunityReplyDTO communityReplyDTO) {
        communityReplyDAO.save(communityReplyDTO);
    }

    @Override
    public void registerDepth(CommunityReplyDTO communityReplyDTO) {
        communityReplyDAO.saveDepth(communityReplyDTO);
    }

    @Override
    public List<CommunityReplyDTO> getList(Long communityId, CommunityPagination communityPagination) {
        return communityReplyDAO.findAll(communityId, communityPagination);
    }

    @Override
    public int getTotal(Long communityId) {
        return communityReplyDAO.findCountOfReply(communityId);
    }

    @Override
    public void registerMiddle(Long id, Long memberId, Long communityId) {
        communityReplyDAO.saveMiddle(id, memberId, communityId);
    }

    @Override
    public void modify(CommunityReplyDTO communityReplyDTO) {
        communityReplyDAO.setCommunityReplyDTO(communityReplyDTO);
    }

    @Override
    public void remove(Long id) {
        communityReplyDAO.delete(id);
    }

    @Override
    public void removeAll(Long communityId) {
        communityReplyDAO.deleteAll(communityId);
    }
}
