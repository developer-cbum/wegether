package com.wegether.app.service.account;

import com.wegether.app.domain.dto.ProfileMemberDTO;
import com.wegether.app.domain.vo.MemberVO;

import java.lang.reflect.Member;
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

    //카카오 로그인 상태 업데이트
    public void changeLoginStatusToKakao(String memberId, String snsProfile);


    //네이버 로그인 상태 업데이트
    public void changeLoginStatusToNaver(String memberId, String snsProfile);


//    //네이버 로그인 상태 업데이트
//    public void changeLoginStatusToNaver(String memberId);



    //아이디 찾기 세션으로
    public Optional<MemberVO> getMemberById(Long id);


    //   프로필 포함 아이디 조회
    public Optional<ProfileMemberDTO> getIdAndProfile(Long id);


    //마이페이지 프로필 설정

    public void setProfile(MemberVO memberVO);

    //    마이페이지 프로필 사진 삭제
    public void setBasicProfileImage(Long id);

    //    마이페이지 프로필 사진 수정
    public void setProfileImage(MemberVO memberVO);

}












