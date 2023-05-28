package com.wegether.app.controller;


import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.domain.vo.MemberVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.data.DataService;
import com.wegether.app.service.mypage.*;
import com.wegether.app.service.project.ProjectService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")

public class MypageController {


    //    마이페이지 메인
    private final MineServiceImpl mine;

    @GetMapping("/my-page/my-page")
    public void main(Long id, Model model) {

        model.addAttribute("main", mine.loadMine(5L));
    }
//===========================================================================================================================
//    비밀번호 재설정

    private final AccountService accountService;

    //   비밀번호 재설정 form 으로 이동
    @GetMapping("/setting/setting-password")
    public void goSettingPW(MemberVO memberVO, Model model, HttpSession session) {
        model.addAttribute("member", accountService.getMemberById((Long) session.getAttribute("id")).get());
    }


    // 사용자가 입력한 비밀번호와 세션에 등록된 비밀번호 비교
// 에이작스로 보낼 것
    @GetMapping("/setting/compare")
    @ResponseBody
    public String goToChangePasswordForm(MemberVO memberVO, HttpSession session) {


//        그 아이디에 해당하는 세션에 등록된 비밀번호를 가져온다
//        사용자가 입력한 비밀번호와 비교한다 > js
//        비밀번호가 같으면 return /accounts/login


//       세션에 있는 아이디로 비밀번호를 가져온다
        Optional<MemberVO> info = accountService.getMemberById((Long) session.getAttribute("id"));

        String dbPW = info.get().getMemberPassword();
        return dbPW;

    }

    //    비밀번호 재설정 완료
    @PostMapping("/setting/setting-password")
    public RedirectView changePassword(MemberVO memberVO, HttpSession session) {
        log.info(memberVO.getMemberPassword());
        accountService.changePassword((Long) session.getAttribute("id"), memberVO.getMemberPassword());
        return new RedirectView("/mypage/my-page/my-page");
    }

//===========================================================================================================================

//    비밀번호 확인 페이지 이동

    @GetMapping("/setting/check-password")
    public void goCheckPW(MemberVO memberVO, Model model, HttpSession session) {

        model.addAttribute("member", accountService.getMemberById((Long) session.getAttribute("id")).get());
    }

    @GetMapping("/setting/comparePW")
    @ResponseBody
    public String goToCherkFor(MemberVO memberVO, HttpSession session) {


        Optional<MemberVO> info = accountService.getMemberById((Long) session.getAttribute("id"));

        String dbPW = info.get().getMemberPassword();
        return dbPW;

    }

    //===========================================================================================================================
//    기본 정보 설정 페이지 이동
//    @GetMapping("/setting/basic-setting")
//    public void goToBasicSetting(HttpSession session, Model model) {
//        model.addAttribute("setting",  mine.loadMine((Long) session.getAttribute("id")).get());
//    }


    @PostMapping("/setting/basic")
    public RedirectView basicSetting(HttpSession session, MemberVO memberVO){
        mine.modifyBasicSetting(memberVO);
        return new RedirectView("/my-page/my-page");

    }


//===========================================================================================================================

    //    회원 탈퇴
//    @GetMapping("/setting/member-secession")
//    public void goToWithdrawal(HttpSession session, Model model) {
//
//        model.addAttribute("withdraw", mine.loadMine((Long) session.getAttribute("id")).get());
//
//
//    }

//    회원 탈퇴 완료

    @PostMapping("withdrawMember")
    public RedirectView goToMain(HttpSession session){

      mine.changeAccount((Long) session.getAttribute("id"));
      session.invalidate();

      return new RedirectView("/index/main");

    }


//===========================================================================================================================
    //    서비스 : 간편결제
    private final CardImpl card;

    //    카드 리스트
    @GetMapping("/pay-card/list")
    public String goToListForm() {
        return "/mypage/pay-card/pay-card";
    }

    @PostMapping("/pay-card/list")
    @ResponseBody
    public List<CardDTO> list(Long memberId, Model model, HttpSession session) {
        return card.getList((Long) session.getAttribute("id"));
    }


    //        카드 등록 후 리스트
    @PostMapping("/pay-card/register")
    @ResponseBody
    public void register(@RequestBody CardDTO cardDTO) {
        log.info(cardDTO.toString());
        card.register(cardDTO);
    }


    //    카드 삭제
    @PostMapping("/pay-card/remove")
    public RedirectView withdraw(Long id) {
        card.remove(id);
        return new RedirectView("/pay-card/pay-card");
    }

    //    1:1문의
    private final InquiryImpl inquiry;

    //목록 조회
    @GetMapping("/inquiry/inquiry-detail")
    public void goToDetail(Long memberId, Model model) {
        model.addAttribute("inquiry", inquiry.read(1L));
    }


    //    내 자료
    private final DataService dataService;


    @GetMapping("/my-page/my-data-list")
    public void goToData(Long memberId, Model model) {
        model.addAttribute("datas", mine.readMine(1L));
    }

    //    내 상담
    @GetMapping("/my-page/my-consult-detail")
    public void goToConsulting(Long memberId, Model model) {
        model.addAttribute("consulting", mine.readMyConsulting(1L));
    }

    //    내 프로젝트
    private final ProjectService projectService;


    // 첫화면 페이지 이동
    @GetMapping("/my-page/my-project-list")
    public void goToProject(Long memberId, Model model) {
        model.addAttribute("projects", mine.readMyProject(2L));
    }


//    프로젝트 삭제
//    @RequestMapping(value = "/remove", method = RequestMethod.GET)
//    public RedirectView remove(Long id){
//        projectService.remove(projectService.getProject()
//
//
//    }

    //    프로젝트 찜
    private final HeartImpl heart;

//    @GetMapping("/heart-list/heart")
//    public void goToHeart(Long memberId, Model model){
//        model.addAttribute("projectH", heart.projectHeart(1L));
//    }

//  찜
//    찜 첫 화면
//    @GetMapping("/heart-list/heart")
//    public void goToHeart(Long memberId, Model model){
//        model.addAttribute("hearts")
//
//    }

    //찜 목록 페이지 이동
    @GetMapping("/heart-list/heart")
    public void goToHeartPage(Long memberId) {
        ;
    }


    //    전체 찜 목록 화면에 전달
    @GetMapping("/heart-list/all")
    @ResponseBody
    public List<HeartDTO> goToAllHearts(Long memberId) {

        final List<HeartDTO> hearts = heart.allHearts(2L);
//        log.info(String.valueOf(hearts));
        return hearts;

        //model.addAttribute("projectH", heart.projectHeart(2L));
    }


    //프로젝트 찜 목록 화면에 전달
    @GetMapping("/heart-list/project")
    @ResponseBody
    public List<ProjectDTO> goToProjectHeart() {

        final List<ProjectDTO> projects = heart.projectHeart(2L);
        log.info(String.valueOf(projects));
        return projects;

        //model.addAttribute("projectH", heart.projectHeart(2L));
    }


    //데이터 찜 목록 화면에 전달
    @GetMapping("/heart-list/data")
    @ResponseBody
    public List<DataDTO> goToDataHeart(Long memberId) {

        final List<DataDTO> datas = heart.dataHeart(2L);
        log.info(String.valueOf(datas));
        return datas;

        //model.addAttribute("projectH", heart.projectHeart(2L));
    }
}


//    찜 첫 화면
//    @GetMapping("/heart-list/heart")
//    public void goToHeart
//
//
//
//}
