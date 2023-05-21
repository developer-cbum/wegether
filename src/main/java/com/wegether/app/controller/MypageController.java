package com.wegether.app.controller;


import com.wegether.app.domain.dto.MemberDTO;



import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.service.mypage.CardImpl;
import com.wegether.app.service.mypage.InquiryImpl;
import com.wegether.app.service.mypage.MineServiceImpl;
import com.wegether.app.service.mypage.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")

public class MypageController {

//    마이페이지 메인
    private final MineServiceImpl mine;

    @GetMapping("/my-page/my-page")
    public void main(Long id, Model model){

        model.addAttribute("main", mine.loadMine(2L).get());
    }

//
//    //    서비스 : 간편결제
//    private final CardImpl card;
//
//    //    카드 리스트
//    @GetMapping("/pay-card/pay-card")
//    public void list(Long memberId, Model model) {
//        model.addAttribute("cards", card.getList(memberId));
//    }
//
///*    카드 등록 모달 화면
//    모달인데 매핑 ?*/
///*    @GetMapping("/pay-card/pay-card")
//    public void goToWriteForm(CardVO cardVO){;}*/
//
//    //    카드 등록 후 리스트
//    @PostMapping("register")
//    public RedirectView register(CardVO cardVO) {
//        card.register(cardVO);
//        return new RedirectView("/pay-card/pay-card");
//    }
//
//    //    카드 삭제
//    @PostMapping("remove")
//    public RedirectView withdraw(Long id) {
//        card.remove(id);
//        return new RedirectView("/pay-card/pay-card");
//    }

//    1:1문의
    private final InquiryImpl inquiry;

    //목록 조회
    @GetMapping("/inquiry/inquiry-detail")
    public void goToDetail(Long memberId, Model model) {
        model.addAttribute("inquiry", inquiry.read(1L));
    }


//    내 자료


    @GetMapping("/my-page/my-data-list")
    public void goToData(Long memberId, Model model) {
        model.addAttribute("data", mine.readMine(1L));
    }

    //    내 상담
    @GetMapping("/my-page/my-consult-detail")
    public void goToConsulting(Long memberId, Model model) {
    model.addAttribute("consulting", mine.readMyConsulting(1L));
    }
}
