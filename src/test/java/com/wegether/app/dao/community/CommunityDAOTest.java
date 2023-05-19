package com.wegether.app.dao.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.vo.CommunityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityDAOTest {

    @Autowired
    private CommunityDAO communityDAO;

    @Test
    public void findAllTest() { assertThat(communityDAO.findAll()).hasSize(4);}

    @Test
    public void findbyIdTest() {
        final Optional<CommunityDTO> foundCommunity = communityDAO.findById(1L);
        foundCommunity.ifPresent(communityVO -> assertThat(communityVO.getCommunityTitle()).isEqualTo("첫 게시글"));
    }

    @Test
    public void saveTest() {
        CommunityDTO communityDTO = new CommunityDTO();
        communityDTO.setMemberId(1L);
        communityDTO.setCommunityTitle("인설트");
        communityDTO.setCommunitySubtitle("인설트테스트");
        communityDTO.setCommunityContent("인썰트테스트임당");
        communityDAO.save(communityDTO);
    }

    @Test
    public void setCommunityDAOTest() {
        Optional<CommunityDTO> foundCommunity = communityDAO.findById(1L);
        foundCommunity.ifPresent(communityDTO -> communityDTO.setCommunityContent("삐약삐약"));
        CommunityDTO communityDTO = foundCommunity.orElseThrow();
        communityDAO.setCommunityDTO(communityDTO);
        foundCommunity = communityDAO.findById(1L);
        foundCommunity.ifPresent(community -> assertThat(community.getCommunityContent()).isEqualTo("삐약삐약"));

    }

    @Test
    public void deleteTest(){
        communityDAO.delete(21L);
        assertThat(communityDAO.findAll()).hasSize(5);
    }

}
