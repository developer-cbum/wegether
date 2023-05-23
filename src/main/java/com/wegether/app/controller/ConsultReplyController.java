package com.wegether.app.controller;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.service.consult.ConsultReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ConsultReplyController {

    private final HttpSession session;
    private final ConsultReplyService consultReplyService;

    //댓글등록
    @PostMapping("register")
    @Transactional(rollbackFor = Exception.class)
    public void register(@RequestBody ConsultReplyDTO consultReplyDTO, Model model){
        log.info(consultReplyDTO.toString());
        consultReplyService.registerReply(consultReplyDTO);
        log.info(consultReplyDTO.getId().toString());
        consultReplyService.registerMiddle(consultReplyDTO.getId(), (Long)session.getAttribute("id"), consultReplyDTO.getConsultingId());
    }

    //댓글조회
    @GetMapping("list/{consultingId}/{page}")
    public List<ConsultReplyDTO> getList(@PathVariable Long consultingId, @PathVariable Integer page) {
        LecturePagination lecturePagination = new LecturePagination();
        lecturePagination.setPage(page);
        lecturePagination.setTotal(consultReplyService.getTotal(consultingId));
        lecturePagination.progress(5, 5);
        return consultReplyService.getList(consultingId, lecturePagination);
    }

    //대댓글 등록
    @PostMapping("register-again")
    @Transactional(rollbackFor = Exception.class)
    public void registerAgain(@RequestBody ConsultReplyDTO consultReplyDTO){
        log.info("대댓글 컨트롤러");
        log.info(consultReplyDTO.toString());
        consultReplyService.registerReplyAgain(consultReplyDTO);
        log.info(consultReplyDTO.getId().toString());
        consultReplyService.registerMiddle(consultReplyDTO.getId(), (Long)session.getAttribute("id"), consultReplyDTO.getConsultingId());
    }

    //대댓글조회
    @GetMapping("again-list/{consultingId}")
    public  List<ConsultReplyDTO> getListAgain(@PathVariable  Long consultingId){
        return consultReplyService.getListAgain(consultingId);
    }


}

