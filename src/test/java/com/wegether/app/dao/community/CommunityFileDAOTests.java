package com.wegether.app.dao.community;

import com.wegether.app.dao.CommunityFileDAO;
import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class CommunityFileDAOTests {

    @Autowired
    private CommunityFileDAO communityFileDAO;

    @Autowired
    private FileDAO fileDAO;

    @Test
    public void saveTest() {
        CommunityFileDTO communityFileDTO = new CommunityFileDTO();
        communityFileDTO.setFileName("새빨간로즈.png");
        communityFileDTO.setFilePath("2023/05/19");
        communityFileDTO.setFileSize(1238L);
        communityFileDTO.setFileUuid(UUID.randomUUID().toString());
        log.info(communityFileDTO.toString());
        fileDAO.save(communityFileDTO);
    }

    @Test
    public void communityFileSaveTest(){
        CommunityFileVO communityFileVO = new CommunityFileVO();
        communityFileVO.setId(88L);
        communityFileVO.setCommunityId(47L);
        communityFileDAO.save(communityFileVO);
    }

    @Test
    public void selectAllTest() {
        fileDAO.findAll(31L).stream().map(CommunityFileDTO::toString).forEach(log::info);
    }
}
