package com.wegether.app.service.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.dao.CommunityFileDAO;
import com.wegether.app.dao.CommunityReplyDAO;
import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.CommunityReplyVO;
import com.wegether.app.domain.vo.CommunityVO;
import com.wegether.app.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityServiceImpl implements CommunityService {

    private final CommunityDAO communityDAO;
    private final CommunityFileDAO communityFileDAO;
    private final FileDAO fileDAO;
    private final CommunityReplyDAO communityReplyDAO;
    private final CommunityFileVO communityFileVO;
    private final FileVO fileVO;
    private final CommunityFileDTO communityFileDTO;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<CommunityDTO> getList(CommunityPagination communityPagination) {
//        게시글 전체 목록
        final List<CommunityDTO> communityDTOS = communityDAO.findAll(communityPagination);
//        게시글 하나씩 첨부파일 목록 담기
        communityDTOS.forEach(communityDTO -> communityDTO.setFiles(fileDAO.communityFindAll(communityDTO.getId())));
        return communityDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<CommunityDTO> getCommunity(Long id) {
        final Optional<CommunityDTO> foundPost = communityDAO.findById(id);
        if(foundPost.isPresent()){
            foundPost.get().setFiles(fileDAO.communityFindAll(foundPost.get().getId()));
        }
        return foundPost;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(CommunityDTO communityDTO) {
        communityDAO.save(communityDTO);
        for(int i=0; i<communityDTO.getFiles().size(); i++){
            communityDTO.getFiles().get(i).setCommunityId(communityDTO.getId());
            communityDTO.getFiles().get(i).setFileType(i == 0 ? FileType.REPRESENTATIVE.name() : FileType.NON_REPRESENTATIVE.name());
            fileDAO.communitySave(communityDTO.getFiles().get(i));
        }
        communityDTO.getFiles().forEach(communityFileDTO ->
        { CommunityFileVO communityFileVO = new CommunityFileVO();
            communityFileVO.setId(communityFileDTO.getId());
            communityFileVO.setCommunityId(communityFileDTO.getCommunityId());
            communityFileDAO.save(communityFileVO);
        });

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(CommunityDTO communityDTO) {

        communityDAO.setCommunityDTO(communityDTO);

        for(int i=0; i<communityDTO.getFiles().size(); i++){
            communityDTO.getFiles().get(i).setCommunityId(communityDTO.getId());
            communityDTO.getFiles().get(i).setFileType(i == 0 ? FileType.REPRESENTATIVE.name() : FileType.NON_REPRESENTATIVE.name());
            fileDAO.communitySave(communityDTO.getFiles().get(i));
        }
        communityDTO.getFiles().forEach(communityFileDTO ->
        { CommunityFileVO communityFileVO = new CommunityFileVO();
            communityFileVO.setId(communityFileDTO.getId());
            communityFileVO.setCommunityId(communityFileDTO.getCommunityId());
            communityFileDAO.save(communityFileVO);
        });

        communityDTO.getFileIdsForDelete().forEach(fileDAO::communityDelete);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        CommunityDTO communityDTO = communityDAO.findById(id).get();
        List<CommunityFileDTO> files = fileDAO.communityFindAll(communityDTO.getId());
//        log.info("==========" + files.toString());
//        log.info("===================" + communityDTO.toString());
        files.forEach(communityFileDTO -> {
            log.info("======================" + communityFileDTO.toString());
            communityFileDAO.delete(communityFileDTO.getCommunityId());
            log.info("===============" + communityFileDTO.toString());
            fileDAO.communityDelete(communityFileDTO.getId());
        });
        List<CommunityReplyVO> replies = communityReplyDAO.findMiddleAll(communityDTO.getId());
        log.info("===================" + replies.toString());
        replies.forEach(reply -> {
            communityReplyDAO.deleteMiddle(reply.getId());
            communityReplyDAO.delete(reply.getId());
        });
//        log.info("===================" + communityDTO.getFiles().toString());
//        log.info("===================" + communityDTO.toString());
        communityDAO.delete(communityDTO.getId());
    }

    @Override
    public int getTotal() {
        return communityDAO.findCountOfCommunity();
    }

}
