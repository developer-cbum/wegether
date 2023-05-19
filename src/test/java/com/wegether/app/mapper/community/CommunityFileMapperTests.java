package com.wegether.app.mapper.community;

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
    private CommunityFileMapper communityFileMapper;

    @Test
    public void insertTest() {
        FileVO fileVO = new FileVO();
        fileVO.setFileName("새빨간로즈.png");
        fileVO.setFilePath("2023/05/19");
        fileVO.setFileSize(1238L);
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFileType("후후후");
        communityFileMapper.insert(fileVO);
    }

    @Test
    public void selectAllTest() {
        communityFileMapper.selectAll(31L).stream().map(FileVO::toString).forEach(log::info);
    }

    @Test
    public void deleteTest() {
        communityFileMapper.delete(1L);
        assertThat(communityFileMapper.selectAll(31L)).hasSize(0);
    }

}