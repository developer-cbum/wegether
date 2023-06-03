package com.wegether.app.dao;

import com.wegether.app.domain.dto.MemberDTO;
import com.wegether.app.domain.dto.ProfileMemberDTO;
import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    //    아이디 중복검사
    public Optional<MemberVO> findByMemberId(String memberId) {
        return memberMapper.selectByMemberId(memberId);
    }

    //    회원가입
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    //    로그인
    public Optional<Long> findByMemberIdAndMemberPassword(String memberId, String memberPassword) {
        return memberMapper.selectByMemberIdAndMemberPassword(memberId, memberPassword);
    }

    //비밀번호 재설정
    public void setPassword(Long id, String memberPassword) {
        memberMapper.updatePassword(id, memberPassword);
    }

    //카카오 로그인 상태 업데이트
//    public void setLoginStatusToKakao(String memberId) {
//        memberMapper.updateLoginStatusToKakao(memberId);
//    }
//
//    //네이버 로그인 상태 업데이트
//    public void setLoginStatusToNaver(String memberId) {
//        memberMapper.updateLoginStatusToNaver(memberId);
//    }
    public void setLoginStatusToKakao(String memberId, String snsProfile){memberMapper.updateLoginStatusToKakao(memberId, snsProfile);}

    //네이버 로그인 상태 업데이트
    public void setLoginStatusToNaver(String memberId, String snsProfile){memberMapper.updateLoginStatusToNaver(memberId, snsProfile);}

    // 세션값으로 회원정보찾기
    public Optional<MemberVO> findById(Long id) {
        return memberMapper.selectById(id);
    }

    //   프로필 포함 아이디 조회
    public Optional<ProfileMemberDTO> findIdAndProfile(Long id) {
        return memberMapper.selectIdAndProfile(id);
    }

//      마이페이지 프로필 설정
    public void setProfile(MemberVO memberVO){
        memberMapper.updateProfile(memberVO);
    }

    //    마이페이지 프로필 사진 삭제
    public void setBasicProfileImage(Long id){memberMapper.updateBasicProfileImage(id);}

    //    마이페이지 프로필 사진 수정
    public void setProfileImage(MemberVO memberVO){memberMapper.updateProfileImage(memberVO);};















    //    소영 마이페이지 화면 띄우기
    public Optional<MemberDTO> showmypage(Long id){
        return memberMapper.selectmypage(id);
    }



    public void updateMemberS (Long id){
        memberMapper.updateMemberS(id);
    }


    public void setBasicSetting(Long id, String memberNickname, String memberPhoneNumber) {
        memberMapper.updateBasicSet(id, memberNickname, memberPhoneNumber);
    }

    public void linkConnection(Long memberId){
        memberMapper.updateConnection(memberId);
    }


}





















