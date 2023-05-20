package com.wegether.app.service.account;

import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.service.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;


    @Test
    public void AccountCheckIdTests(){
        Optional<MemberVO> foundMemberVO = accountService.checkId("friend_7-9@naver.com");
        assertThat(foundMemberVO.isPresent()).isEqualTo(true);
        log.info(foundMemberVO.get().toString());
    }

    @Test
    public void AccountJoinTests(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberId("lss1234@naver.com");
        memberVO.setMemberPassword("!dltnstls159");
        memberVO.setMemberName("이순신");
        memberVO.setMemberNickname("장군님");
        memberVO.setMemberPhoneNumber("01012341234");
        accountService.join(memberVO);
    }

    @Test
    public void changePasswordTest(){
        accountService.changePassword(1L, "!dlwhdans159");
    }

    @Test
    public void getMemberById(){
        log.info(accountService.getMemberById(1L).get().toString());
    }

}
