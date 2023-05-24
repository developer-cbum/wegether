package com.wegether.app.service.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.domain.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityReplyServiceImpl implements CommunityReplyService{

    private final CommunityReplyDAO communityReplyDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(CommunityReplyDTO communityReplyDTO) {
        communityReplyDAO.save(communityReplyDTO);
//        CommunityReplyDTO replyForMiddleTbl = communityReplyDAO.saveMiddle(communityReplyDTO,);
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
    public List<CommunityReplyDTO> getListAgain(Long communityId) {
        return communityReplyDAO.findAllAgain(communityId);
    }

    @Override
    public int getTotal(Long communityId) {
        return communityReplyDAO.findCountOfReply(communityId);
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
