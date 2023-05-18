package com.wegether.app.mapper.community;

import com.wegether.app.domain.vo.CommunityVO;
import com.wegether.app.mapper.CommunityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityMapperTest {

    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void selectTest() {
        final Optional<CommunityVO> foundCommunity = communityMapper.select(1L);
        foundCommunity.ifPresent(communityVO -> assertThat(communityVO.getCommunityTitle()).isEqualTo("첫 게시글"));

    }

    @Test
    public void insertTest() {
        CommunityVO communityVO = new CommunityVO();
        communityVO.setMemberId(1L);
        communityVO.setCommunityTitle("나는 초콜렛이야");
        communityVO.setCommunitySubtitle("다양한 맛을 가지고 있어");
        communityVO.setCommunityContent("나는야 하이클래쓰 보이");
        communityMapper.insert(communityVO);
    }

    @Test
    public void updateTest() {
        Optional<CommunityVO> foundCommunity = communityMapper.select(1L);
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityTitle("제목수정"));
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunitySubtitle("섭타이틀수정"));
        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityContent("내용수정"));

        CommunityVO communityVO = foundCommunity.orElseThrow();

        communityMapper.update(communityVO);

        foundCommunity = communityMapper.select(1L);

        foundCommunity.ifPresent(community -> assertThat(community.getCommunityTitle()).isEqualTo("제목수정"));
    }
}
