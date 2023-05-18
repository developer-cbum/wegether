package com.wegether.app.service.account;

import com.wegether.app.domain.vo.MemberVO;

import java.util.Optional;

public interface AccountService {

    //    아이디 중복검사
    public Optional<MemberVO> checkId(String memberId);

    //    회원가입
    public void join(MemberVO memberVO);

    //    로그인
    public Optional<Long> login(String memberId, String memberPassword);

    // 비밀번호 재설정
    public void changePassword(Long id, String memberPassword);

}




















