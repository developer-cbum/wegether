package com.wegether.app.service.community;

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
        final Optional<CommunityVO> foundCommunity = communityService.getCommunity(1L);
        foundCommunity.ifPresent(communityVO -> assertThat(communityVO.getCommunityTitle()).isEqualTo("첫 게시글"));
    }

    @Test
    public void writeTest(){
        CommunityVO communityVO = new CommunityVO();
        communityVO.setMemberId(1L);
        communityVO.setCommunityTitle("인설트");
        communityVO.setCommunitySubtitle("인설트테스트");
        communityVO.setCommunityContent("인썰트테스트임당");
        communityService.write(communityVO);
    }

    @Test
    public void modifyTest() {
        Optional<CommunityVO> foundCommunity = communityService.getCommunity(1L);
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityContent("점핑예점핑"));
        CommunityVO communityVO = foundCommunity.orElseThrow();
        communityService.modify(communityVO);
        foundCommunity = communityService.getCommunity(1L);
        foundCommunity.ifPresent(community -> assertThat(community.getCommunityContent()).isEqualTo("점핑예점핑"));
    }

    @Test
    public void removeTest() {
        communityService.remove(22L);
        assertThat(communityService.getList()).hasSize(4);
    }
}
