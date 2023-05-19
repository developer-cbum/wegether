package com.wegether.app.service.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityPagination;
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
    public void getListTest() {
        CommunityPagination communityPagination = new CommunityPagination(3);
        communityPagination.setPage(1);
        communityService.getList(communityPagination).stream().map(CommunityDTO::toString).forEach(log::info);
    }

    @Test
    public void findByIdTest(){
        communityService.getCommunity(23L).map(CommunityDTO::toString).ifPresent(log::info);
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
