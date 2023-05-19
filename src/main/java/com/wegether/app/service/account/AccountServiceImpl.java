package com.wegether.app.service.account;

import com.wegether.app.dao.MemberDAO;
import com.wegether.app.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final MemberDAO memberDAO;

    @Override
    public Optional<MemberVO> checkId(String memberId) {
        return memberDAO.findByMemberId(memberId);
    }

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

    @Override
    public Optional<Long> login(String memberId, String memberPassword){
        return memberDAO.findByMemberIdAndMemberPassword(memberId, memberPassword);
    }

    @Override
    public void changePassword(Long id, String memberPassword) {
        memberDAO.setPassword(id, memberPassword);
    }

    @Override
    public void changeLoginStatusToKakao(String memberId) {
        memberDAO.setLoginStatusToKakao(memberId);
    }

    @Override
    public Optional<MemberVO> getMemberById(Long id) {
        return memberDAO.findById(id);
    }
}
