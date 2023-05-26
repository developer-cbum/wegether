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
import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/datas/*")
public class DataController {
    private final DataService dataService;
    private final AccountService accountService;


//    자료 목록 - 기본
//    @GetMapping("list")
//    public void goToDataList(DataPagination dataPagination, CategoryType categoryType, @RequestParam(defaultValue = "all") String type, @RequestParam(defaultValue = "new") String order, Model model){
//        dataPagination.setTotal(dataService.getTotal());
//        dataPagination.progress();
//        categoryType.setType(type);
//        categoryType.setOrder(order);
//        model.addAttribute("datas", dataService.getList(dataPagination, categoryType));
//    }

    @GetMapping("list")
    public void goToList(){;}

    //    자료 목록 - rest 시도 중 ..

//    @ResponseBody
//    @GetMapping("computer-list/{page}/{type}")
//    public List<DataDTO> goToDataList(@PathVariable int page, @PathVariable String type){
//        final DataPagination dataPagination = new DataPagination();
//        dataPagination.setPage(page);
//        dataPagination.progress();
//        dataPagination.setTotal(dataService.getTotal());
//        dataPagination.progress();
//        CategoryType categoryType = new CategoryType();
//        categoryType.setType(type);
//       return dataService.getList(dataPagination, categoryType);
//    }
//    @GetMapping("list/{postId}/{page}")
//    public List<ReplyDTO> getList(@PathVariable int page, @PathVariable Long postId){
//        final Pagination pagination = new Pagination();
//        pagination.setPage(page);
//        pagination.progress();
//        return replyService.getList(postId, pagination);
//    }

    @ResponseBody
    @GetMapping("list/{page}/{type}/{order}")
    public List<DataDTO> goToDataList(@PathVariable int page, @PathVariable String type, @PathVariable String order){
        DataPagination dataPagination = new DataPagination();
        CategoryType categoryType = new CategoryType();
        dataPagination.setTotal(dataService.getTotal());
        dataPagination.progress(8);
        dataPagination.setPage(page);
        categoryType.setType(type);
        categoryType.setOrder(order);
       return dataService.getList(dataPagination, categoryType);
    }



    //    자료 상세
    @GetMapping("detail")
    public void read(@RequestParam Long id, Model model, DataDTO dataDTO){
        dataService.modifyViewCountUp(dataDTO.getId());
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
    
//    자료 결제 페이지
    @GetMapping("payment")
    public void goToPayment(@RequestParam Long id, Model model, DataDTO dataDTO){;
//        Optional<DataDTO> readDataPay = dataService.readDataPay(id);
        model.addAttribute("dataDTO", dataService.readDataPay(id).get());
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




















