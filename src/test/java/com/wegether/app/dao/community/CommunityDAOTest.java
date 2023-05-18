package com.wegether.app.dao.community;

import com.wegether.app.dao.CommunityDAO;
import com.wegether.app.domain.vo.CommunityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityDAOTest {

    @Autowired
    private CommunityDAO communityDAO;

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
}
