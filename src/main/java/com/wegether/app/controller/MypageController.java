package com.wegether.app.controller;




import com.wegether.app.domain.dto.CardDTO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.HeartDTO;
import com.wegether.app.domain.dto.ProjectDTO;
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

        model.addAttribute("main", mine.loadMine(2L).get());
    }

//    비밀번호 재설정

    private final AccountService accountService;

//   비밀번호 재설정 form 으로 이동
    @GetMapping("/setting/setting-password")
    public void goSettingPW(@RequestParam Long id, MemberVO memberVO, Model model){
        model.addAttribute("id", id);

    }
// 사용자가 입력한 비밀번호와 세션에 등록된 비밀번호 비교

    @GetMapping("/check/setting-password")
    @ResponseBody
    public String changePassword(MemberVO memberVO, HttpSession session){


//        그 아이디에 해당하는 세션에 등록된 비밀번호를 가져온다
//        사용자가 입력한 비밀번호와 비교한다 > js
//        비밀번호가 같으면 return /accounts/login


//       세션에 있는 아이디로 비밀번호를 가져온다
        Optional<MemberVO> info = accountService.getMemberById((Long) session.getAttribute("id"));

        String dbPW=info.get().getMemberPassword();
        return dbPW;

    }
//    비밀번호 재설정 완료
    @PostMapping("/setting/setting-password")
    public RedirectView changePassword(@RequestBody Long id, MemberVO memberVO){
        log.info(memberVO.getMemberPassword());
        log.info(id.toString());
        accountService.changePassword(Long.valueOf(id), memberVO.getMemberPassword());
        return new RedirectView("/my-page/my-page");
    }

//    @PostMapping("setting/setting-password")
//    @ResponseBody
//    public Optional<MemberVO> changePassword(@RequestBody MemberVO memberVO, HttpSession session){
//        log.info(memberVO.getMemberPassword());
//
//        log.info(session.getId());
//
//        session.setAttribute("pw", memberVO.getMemberPassword());
////        그 아이디에 해당하는 세션에 등록된 비밀번호를 가져온다
////        사용자가 입력한 비밀번호와 비교한다 > js
////        비밀번호가 같으면 return /accounts/login
//
//        session.setAttribute("id", memberVO.getId());
//
////       세션에 있는 아이디로 비밀번호를 가져온다
//        Optional<MemberVO> info = accountService.getMemberByPw((Long) session.getAttribute("id"));
//        return info;
//
//
//    }


    //    서비스 : 간편결제
    private final CardImpl card;

    //    카드 리스트
//    @GetMapping("/pay-card/pay-card")
//    public void list(Long memberId, Model model) {
//        model.addAttribute("cards", card.getList(1L));
//    }

/*    카드 등록 모달 화면
    모달인데 매핑 ?*/
/*    @GetMapping("/pay-card/pay-card")
    public void goToWriteForm(CardVO cardVO){;}*/

    //    카드 등록 후 리스트
//    @PostMapping("register")
//    public RedirectView register(@RequestBody CardDTO cardDTO, CardVO CARD) {
//        card.register(cardVO);
//        return new RedirectView("/pay-card/pay-card");
//    }

    //    카드 삭제
    @PostMapping("remove")
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



    //프로젝트 삭제
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
    public void goToHeartPage(Long memberId) {;
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
    @GetMapping("/mypage/heart-list/project")
    @ResponseBody
    public List<ProjectDTO> goToProjectHeart(Long memberId) {

        final List<ProjectDTO> hearts = heart.projectHeart(2L);
        log.info(String.valueOf(hearts));
        return hearts;

        //model.addAttribute("projectH", heart.projectHeart(2L));
    }




//데이터 찜 목록 화면에 전달
    @GetMapping("/mypage/heart-list/data")
    @ResponseBody
    public List<DataDTO> goToDataHeart(Long memberId) {

        final List<DataDTO> hearts = heart.dataHeart(2L);
        log.info(String.valueOf(hearts));
        return hearts;

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
