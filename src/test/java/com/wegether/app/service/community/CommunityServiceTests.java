package com.wegether.app.service.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.vo.CommunityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityServiceTests {

    @Autowired
    private CommunityService communityService;

    @Test
    public void getListTest() { assertThat(communityService.getList()).hasSize(7);}

    @Test
    public void getCommunityTest() {
        final Optional<CommunityDTO> foundCommunity = communityService.getCommunity(1L);
        foundCommunity.ifPresent(community -> assertThat(community.getCommunityTitle()).isEqualTo("첫 게시글"));
    }

    @Test
    public void writeTest(){
        CommunityDTO communityDTO = new CommunityDTO();
        communityDTO.setMemberId(1L);
        communityDTO.setCommunityTitle("인설트");
        communityDTO.setCommunitySubtitle("인설트테스트");
        communityDTO.setCommunityContent("인썰트테스트임당");
        communityService.write(communityDTO);
    }

    @Test
    public void modifyTest() {
        Optional<CommunityDTO> foundCommunity = communityService.getCommunity(1L);
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityContent("점핑예점핑"));
        CommunityDTO communityDTO = foundCommunity.orElseThrow();
        communityService.modify(communityDTO);
        foundCommunity = communityService.getCommunity(1L);
        foundCommunity.ifPresent(community -> assertThat(community.getCommunityContent()).isEqualTo("점핑예점핑"));
    }

    @Test
    public void removeTest() {
        communityService.remove(22L);
        assertThat(communityService.getList()).hasSize(4);
    }
}
