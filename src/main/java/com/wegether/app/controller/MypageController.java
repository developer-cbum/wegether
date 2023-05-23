package com.wegether.app.controller;




import com.wegether.app.domain.dto.CardDTO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.CardVO;
import com.wegether.app.domain.vo.InquiryVO;
import com.wegether.app.service.data.DataService;
import com.wegether.app.service.mypage.*;
import com.wegether.app.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

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


    //    서비스 : 간편결제
    private final CardImpl card;

    //    카드 리스트
    @GetMapping("/pay-card/pay-card")

    public void list(Long memberId, Model model) {
        model.addAttribute("cards", card.getList(1L));
    }

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

    @GetMapping("/my-page/my-project-list")
    public void goToProject(Long memberId, Model model){
        model.addAttribute("projects",mine.readMyProject(2L));
    }

//    프로젝트 찜
    private final HeartImpl heart;

//    @GetMapping("/heart-list/heart")
//    public void goToHeart(Long memberId, Model model){
//        model.addAttribute("projectH", heart.projectHeart(1L));
//    }

    @GetMapping("/heart-list/heart")
    @ResponseBody
    public List<ProjectDTO> goToHeart(Long memberId){

        final List<ProjectDTO> hearts = heart.projectHeart(1L);
        log.info(String.valueOf(hearts));
        return hearts;

        //model.addAttribute("projectH", heart.projectHeart(2L));
    }


}
