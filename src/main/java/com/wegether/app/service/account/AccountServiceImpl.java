package com.wegether.app.service.account;

import com.wegether.app.dao.MemberDAO;
import com.wegether.app.dao.PointDAO;
import com.wegether.app.domain.dto.ProfileMemberDTO;
import com.wegether.app.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final MemberDAO memberDAO;
    private final PointDAO pointDAO;

    @Override
    public Optional<MemberVO> checkId(String memberId) {
        return memberDAO.findByMemberId(memberId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
        Optional<MemberVO> byMemberId = memberDAO.findByMemberId(memberVO.getMemberId());
        pointDAO.saveJoinPoint(byMemberId.get().getId());
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
    public void changeLoginStatusToNaver(String memberId) {
        memberDAO.setLoginStatusToNaver(memberId);
    }

    @Override
    public Optional<MemberVO> getMemberById(Long id) {
        return memberDAO.findById(id);
    }

    @Override
    public Optional<MemberVO> getMemberByPw(Long id) {
        return memberDAO.showByPW(id);
    }

    @Override
    public Optional<ProfileMemberDTO> getIdAndProfile(Long id) {
        return memberDAO.findIdAndProfile(id);
    }
}
