package com.wegether.app.controller;

import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.DataPagination;
import com.wegether.app.domain.type.CategoryType;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.data.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/datas/*")
public class DataController {
    private final DataService dataService;
    private final AccountService accountService;


//    자료 목록
    @GetMapping("list")
    public void goToDataList(DataPagination dataPagination, CategoryType categoryType, @RequestParam(defaultValue = "all") String type, @RequestParam(defaultValue = "new") String order, Model model){
        dataPagination.setTotal(dataService.getTotal());
        dataPagination.progress();
        categoryType.setType(type);
        categoryType.setOrder(order);
        model.addAttribute("datas", dataService.getList(dataPagination, categoryType));
    }

//    @GetMapping("list/{dataPagination}/{categoryType}")
//    public void goToDataList(@PathVariable int page, CategoryType categoryType, @RequestParam(defaultValue = "all") String type, @RequestParam(defaultValue = "new") String order){
//        final DataPagination dataPagination = new DataPagination();
//        dataPagination.setTotal(dataService.getTotal());
//        dataPagination.progress();
//        categoryType.setType(type);
//        categoryType.setOrder(order);
//        model.addAttribute("datas", dataService.getList(dataPagination, categoryType));
//    }
//
//    @GetMapping("list/{postId}/{page}")
//    public List<ReplyDTO> getList(@PathVariable int page, @PathVariable Long postId){
//        final Pagination pagination = new Pagination();
//        pagination.setPage(page);
//        pagination.progress();
//        return replyService.getList(postId, pagination);
//    }


    //    자료 상세
    @GetMapping("detail")
    public void read(@RequestParam Long id, Model model){
        model.addAttribute("dataDTO", dataService.read(id).get());
    }



//    자료 등록
    @GetMapping("register")
    public void goToWriteForm(DataDTO dataDTO, Model model){; }

    //    자료 등록 - HttpSession session
//    @GetMapping("register")
//    public void goToRegisterForm(DataDTO dataDTO, HttpSession session, Model model){
//        Long memberId = accountService.getMemberById((Long) session.getAttribute("id")).get().getId();
////        Long memberId = accountService.getMemberById(2L).get().getId();
//        model.addAttribute("memberId", memberId);
//    };


    //    자료 등록 > 리스트 이동
    @PostMapping("register")
    public RedirectView register(DataDTO dataDTO) {
        dataService.write(dataDTO);
        return new RedirectView("/datas/list");
    }







//    @PostMapping("modify")
//    public RedirectView modify(DataDTO dataDTO, RedirectAttributes redirectAttributes){
//        dataService.modify(dataDTO);
//        redirectAttributes.addAttribute("id", dataDTO.getId());
//        return new RedirectView("/data/detail");
//    }
//
//    @PostMapping("remove")
//    public RedirectView remove(Long id){
//        dataService.remove(id);
//        return new RedirectView("/data/list");
//    }

}




















