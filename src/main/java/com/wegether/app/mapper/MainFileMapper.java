package com.wegether.app.mapper;

import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.MainFileDTO;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.DataFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainFileMapper {


    public List<MainFileDTO> mainPFSelectAll(Long projectId);

    public List<MainFileDTO> mainDFSelectAll(Long dataId);

    public List<MainFileDTO> mainCFSelectAll(Long communityId);

    public List<MainFileDTO> mainDRSelectAll(Long dataId);



}