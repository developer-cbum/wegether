package com.wegether.app.dao.community;

import com.wegether.app.dao.CommunityDAO;
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
    public void findAllTest() { assertThat(communityDAO.findAll()).hasSize(7);}

    @Test
    public void findbyIdTest() {
        final Optional<CommunityVO> foundCommunity = communityDAO.findById(1L);
        foundCommunity.ifPresent(communityVO -> assertThat(communityVO.getCommunityTitle()).isEqualTo("첫 게시글"));
    }

    @Test
    public void saveTest() {
        CommunityVO communityVO = new CommunityVO();
        communityVO.setMemberId(1L);
        communityVO.setCommunityTitle("인설트");
        communityVO.setCommunitySubtitle("인설트테스트");
        communityVO.setCommunityContent("인썰트테스트임당");
        communityDAO.save(communityVO);
    }

    @Test
    public void setCommunityDAOTest() {
        Optional<CommunityVO> foundCommunity = communityDAO.findById(1L);
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityContent("삐약삐약"));
        CommunityVO communityVO = foundCommunity.orElseThrow();
        communityDAO.setCommunityVO(communityVO);
        foundCommunity = communityDAO.findById(1L);
        foundCommunity.ifPresent(community -> assertThat(community.getCommunityContent()).isEqualTo("삐약삐약"));

    }

    @Test
    public void deleteTest(){
        communityDAO.delete(21L);
        assertThat(communityDAO.findAll()).hasSize(5);
    }

}
