package com.wegether.app.service.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.CommunityReplyVO;
import com.wegether.app.domain.vo.CommunityVO;
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
    public void register(CommunityReplyDTO communityReplyDTO) {
        communityReplyDAO.save(communityReplyDTO);
    }

    @Override
    public void registerDepth(CommunityReplyDTO communityReplyDTO) {
        communityReplyDAO.saveDepth(communityReplyDTO);
    }

    @Override
    public void registerMiddle(CommunityReplyVO communityReplyVO) {
        communityReplyDAO.saveMiddle(communityReplyVO);
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
    public Optional<CommunityReplyVO> getMiddle(Long id) {
        return communityReplyDAO.findMiddle(id);
    }

    @Override
    public Optional<CommunityReplyDTO> getReply(Long id) {
        return communityReplyDAO.find(id);
    }

    @Override
    public List<CommunityReplyDTO> getAgain(Long replyGroup) {
        return communityReplyDAO.findAgain(replyGroup);
    }

    @Override
    public List<CommunityReplyVO> getMiddleList(Long communityId) {
        return communityReplyDAO.findMiddleAll(communityId);
    }

    @Override
    public int getTotalOfReply(Long id) {
        return communityReplyDAO.findCountOfReply(id);
    }

    @Override
    public int getTotal(Long communityId) {
        return communityReplyDAO.findCount(communityId);
    }

    @Override
    public int getTotalOfReplyAgain(Long id, Long replyGroup) {
        return communityReplyDAO.findCountOfReplyAgain(id, replyGroup);
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
        communityReplyDAO.delete(communityId);
    }

    @Override
    public void removeReplyAgain(Long replyGroup) {
        communityReplyDAO.deleteReplyAgain(replyGroup);
    }

    @Override
    public void removeMiddle(Long id) {
        communityReplyDAO.deleteMiddle(id);
    }
}
