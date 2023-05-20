package com.wegether.app.mapper.community;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityPagination;
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
    public void selectAllTest() {
        CommunityPagination communityPagination = new CommunityPagination(3);
        communityPagination.setPage(1); //화면에서 전달받은 페이지
        communityMapper.selectAll(communityPagination).stream().map(CommunityDTO::toString).forEach(log::info);
//        postMapper.selectAll(pagination, new Search("popular")).stream().map(PostDTO::toString).forEach(log::info);
//        postMapper.selectAll(pagination, new Search()).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest(){
        communityMapper.select(3L).map(CommunityDTO::toString).ifPresent(log::info);
    }

    @Test
    public void insertTest() {
        CommunityDTO communityDTO = new CommunityDTO();
        communityDTO.setMemberId(1L);
        communityDTO.setCommunityTitle("나는 초콜렛이야");
        communityDTO.setCommunitySubtitle("다양한 맛을 가지고 있어");
        communityDTO.setCommunityContent("나는야 하이클래쓰 보이");
        communityMapper.insert(communityDTO);
    }

    @Test
    public void updateTest() {
        Optional<CommunityDTO> foundCommunity = communityMapper.select(29L);
        foundCommunity.ifPresent(communityDTO -> communityDTO.setCommunityTitle("제목수정"));
        foundCommunity.ifPresent(communityDTO -> communityDTO.setCommunitySubtitle("섭타이틀수정"));
        foundCommunity.ifPresent(communityDTO -> communityDTO.setCommunityContent("내용수정"));

        CommunityDTO communityDTO = foundCommunity.orElseThrow();

        communityMapper.update(communityDTO);

        foundCommunity = communityMapper.select(1L);

        foundCommunity.ifPresent(community -> assertThat(community.getCommunityTitle()).isEqualTo("제목수정"));
    }

    @Test
    public void deleteTest(){
        communityMapper.delete(29L);
    }

}
