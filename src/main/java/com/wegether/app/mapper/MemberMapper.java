package com.wegether.app.mapper;

import com.wegether.app.domain.dto.MemberDTO;
import com.wegether.app.domain.dto.ProfileMemberDTO;
import com.wegether.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //아이디 중복검사
    public Optional<MemberVO> selectByMemberId(String memberId);

    // 회원가입
    public void insert(MemberVO memberVO);

    // 로그인
    public Optional<Long> selectByMemberIdAndMemberPassword(String memberId,String memberPassword);

    //비밀번호 재설정
    public void updatePassword(@Param("id") Long id, @Param("memberPassword") String memberPassword);

    //카카오 로그인 상태 업데이트
    public void updateLoginStatusToKakao(String memberId, String snsProfile);

    //네이버로 로그인 상태 업데이트
    public void updateLoginStatusToNaver(String memberId, String snsProfile);

    //아이디 찾기 세션으로
    public Optional<MemberVO> selectById(Long id);

    //   프로필 포함 아이디 조회
    public Optional<ProfileMemberDTO> selectIdAndProfile(Long id);


    // 마이페이지 프로필 설정
    public void updateProfile(MemberVO memberVO);







//    소영 마이페이지 화면 띄우기
    public Optional<MemberDTO> selectmypage(Long id);
    
// 소영 마이페이지 회원 탈퇴
    public void updateMemberS(Long id);

// 소영 마이페이지 기본 정보 수정
    public void updateBasicSet(Long id, String memberNickname, String memberPhoneNumber);

// 마이페이지 연동 update문
    public void updateConnection(Long memberId);

//    마이페이지 사진 가져오기
    public MemberDTO selectMyPageImage(Long id);
}
