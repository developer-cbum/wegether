package com.wegether.app.service.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.vo.CommunityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityServiceTests {

    @Autowired
    private CommunityService communityService;

    @Test
    public void getListTest() {
        CommunityPagination communityPagination = new CommunityPagination(3);
        communityPagination.setPage(1);
        communityService.getList(communityPagination).stream().map(CommunityDTO::toString).forEach(log::info);
    }

    @Test
    public void findByIdTest(){
        communityService.getCommunity(31L).map(CommunityDTO::toString).ifPresent(log::info);
    }

    @Test
    public void writeTest(){

        List<CommunityFileDTO> communityFileDTOS = new ArrayList<>();
        CommunityFileDTO file1 = new CommunityFileDTO();
        CommunityFileDTO file2 = new CommunityFileDTO();
        CommunityFileDTO file3 = new CommunityFileDTO();

        file1.setFileName("새빨간로즈.png");
        file1.setFilePath("2023/05/19");
        file1.setFileSize(1238L);
        file1.setFileUuid(UUID.randomUUID().toString());

        file2.setFileName("새빨간로즈.png");
        file2.setFilePath("2023/05/19");
        file2.setFileSize(1238L);
        file2.setFileUuid(UUID.randomUUID().toString());

        file3.setFileName("새빨간로즈.png");
        file3.setFilePath("2023/05/19");
        file3.setFileSize(1238L);
        file3.setFileUuid(UUID.randomUUID().toString());


        CommunityDTO communityDTO = new CommunityDTO();
        communityDTO.setMemberId(1L);
        communityDTO.setCommunityTitle("인설트");
        communityDTO.setCommunitySubtitle("인설트테스트");
        communityDTO.setCommunityContent("인썰트테스트임당");
        communityFileDTOS.add(file1);
        communityFileDTOS.add(file2);
        communityFileDTOS.add(file3);
        communityDTO.setFiles(communityFileDTOS);
        communityService.write(communityDTO);
    }

    @Test
    public void modifyTest() {
        Optional<CommunityDTO> foundCommunity = communityService.getCommunity(23L);
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityContent("점핑예점핑"));
        CommunityDTO communityDTO = foundCommunity.orElseThrow();
        communityService.modify(communityDTO);
        foundCommunity = communityService.getCommunity(23L);
        foundCommunity.ifPresent(community -> assertThat(community.getCommunityContent()).isEqualTo("점핑예점핑"));
    }

    @Test
    public void removeTest() {
        communityService.remove(23L);
    }

}
