package com.wegether.app.dao.member;

import com.wegether.app.dao.MemberDAO;
import com.wegether.app.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void memberFindByMemberIdTest(){
        Optional<MemberVO> foundByMemberId = memberDAO.findByMemberId("friend_7-9@naver.com");
        assertThat(foundByMemberId.isPresent()).isEqualTo(true);
    }

    @Test
    public void memberSaveTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberId("hds1234@naver.com");
        memberVO.setMemberPassword("!hksehdtjr159");
        memberVO.setMemberName("한동석");
        memberVO.setMemberNickname("강사님");
        memberVO.setMemberPhoneNumber("01012341234");
        memberDAO.save(memberVO);
    }

    @Test
    public void memberFindByMemberIdAndMemberPasswordTests(){
        Optional<Long> foundByMemberIdAndMemberPassword =
                memberDAO.findByMemberIdAndMemberPassword("hds1234@naver.com", "!hksehdtjr159");
        assertThat(foundByMemberIdAndMemberPassword.isPresent()).isEqualTo(true);
    }

    @Test
    public void setMemberPasswordTest(){
        memberDAO.setPassword(1L, "0123456789");
    }

    @Test
    public void findByIdTest(){
        log.info(memberDAO.findById(1L).get().toString());
    }
}
