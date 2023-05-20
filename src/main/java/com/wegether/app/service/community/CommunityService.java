package com.wegether.app.service.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.CommunityVO;
import com.wegether.app.domain.vo.FileVO;

import java.util.List;
import java.util.Optional;

public interface CommunityService {

    public List<CommunityDTO> getList(CommunityPagination communityPagination);

    public Optional<CommunityDTO> getCommunity(Long id);

    public void write(CommunityDTO communityDTO);

    public void modify(CommunityDTO communityDTO);

    public void remove(Long id);

    default CommunityDTO toDTO(CommunityVO communityVO){
        CommunityDTO communityDTO = new CommunityDTO();
        communityDTO.setId(communityVO.getId());
        communityDTO.setMemberId(communityVO.getMemberId());
        communityDTO.setCommunityTitle(communityVO.getCommunityTitle());
        communityDTO.setCommunitySubtitle(communityVO.getCommunitySubtitle());
        communityDTO.setCommunityContent(communityVO.getCommunityContent());
        communityDTO.setCommunityRegisterDate(communityVO.getCommunityRegisterDate());
        communityDTO.setCommunityUpdateDate(communityVO.getCommunityUpdateDate());
        return communityDTO;
    }

    default CommunityFileDTO toDTO(FileVO fileVO){
        CommunityFileDTO communityFileDTO = new CommunityFileDTO();
        communityFileDTO.setId(fileVO.getId());
        communityFileDTO.setFileName(fileVO.getFileName());
        communityFileDTO.setFilePath(fileVO.getFilePath());
        communityFileDTO.setFileUuid(fileVO.getFileUuid());
        communityFileDTO.setFileSize(fileVO.getFileSize());
        return communityFileDTO;
    }

}




















