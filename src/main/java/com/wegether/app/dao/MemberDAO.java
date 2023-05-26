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
    public Optional<MemberVO> findByMemberId(String memberId){
        return memberMapper.selectByMemberId(memberId);
    }

    //    회원가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    //    로그인
    public Optional<Long> findByMemberIdAndMemberPassword(String memberId, String memberPassword){
        return memberMapper.selectByMemberIdAndMemberPassword(memberId, memberPassword);
    }

    //비밀번호 재설정
    public void setPassword(Long id, String memberPassword){
        memberMapper.updatePassword(id, memberPassword);
    }

    //카카오 로그인 상태 업데이트
    public void setLoginStatusToKakao(String memberId){memberMapper.updateLoginStatusToKakao(memberId);}

    //네이버 로그인 상태 업데이트
    public void setLoginStatusToNaver(String memberId){memberMapper.updateLoginStatusToNaver(memberId);}

    // 세션값으로 회원정보찾기
    public Optional<MemberVO> findById(Long id){
        return memberMapper.selectById(id);
    }

    //   프로필 포함 아이디 조회
    public Optional<ProfileMemberDTO> findIdAndProfile(Long id){
        return memberMapper.selectIdAndProfile(id);
    }


















    //    소영 마이페이지 화면 띄우기
    public Optional<MemberDTO> showmypage(Long id){
        return memberMapper.selectmypage(id);
    }



    public void updateMemberS (Long id){
        memberMapper.updateMemberS(id);
    }


    public void setBasicSetting(MemberVO memberVO) {
        memberMapper.updateBasicSet(memberVO);
    }
}





















