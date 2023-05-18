package com.wegether.app.mapper.member;

import com.wegether.app.dao.MemberDAO;
import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void memberInsertTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberId("friend_7-9@naver.com");
        memberVO.setMemberPassword("!dlwhdans159");
        memberVO.setMemberName("이종문");
        memberVO.setMemberNickname("돼지");
        memberVO.setMemberPhoneNumber("01040573327");
        memberMapper.insert(memberVO);
    }

    @Test
    public void selectByMmeberIdTest(){
        Optional<MemberVO> foundMember = memberMapper.selectByMemberId("friend_7-9@naver.com");
        assertThat(foundMember.isPresent()).isEqualTo(true);
    }

    @Test
    public void selelctByMemberIdAndMemberPasswordTest(){
        Optional<Long> foundId = memberMapper.selectByMemberIdAndMemberPassword("friend_7-9@naver.com", "!dlwhdans159");
        assertThat(foundId.isPresent()).isEqualTo(true);
        log.info(foundId.get().toString());
    }


}
