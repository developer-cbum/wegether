package com.wegether.app.mapper.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.mapper.CommunityFileMapper;
import com.wegether.app.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.activation.FileTypeMap;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityFileMapperTests {

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private CommunityFileMapper communityFileMapper;

    @Test
    public void insertTest() {
        CommunityFileDTO communityFileDTO = new CommunityFileDTO();
        communityFileDTO.setFileName("새빨간로즈.png");
        communityFileDTO.setFilePath("2023/05/19");
        communityFileDTO.setFileSize(1238L);
        communityFileDTO.setFileUuid(UUID.randomUUID().toString());
        fileMapper.insert(communityFileDTO);
    }

    @Test
    public void selectAllTest() {
        fileMapper.selectAll(31L).stream().map(CommunityFileDTO::toString).forEach(log::info);
    }

    @Test
    public void communityFileInsertTest() {
        CommunityFileVO communityFileVO = new CommunityFileVO();
        communityFileVO.setId(89L);
        communityFileVO.setCommunityId(45L);
        communityFileMapper.insert(communityFileVO);
    }

//    @Test
//    public void deleteTest() {
//        communityFileMapper.delete(1L);
//        assertThat(communityFileMapper.selectAll(31L)).hasSize(0);
//    }

}