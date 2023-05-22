package com.wegether.app.controller;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.service.consult.ConsultReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void register(@RequestBody ConsultReplyDTO consultReplyDTO){
        log.info(consultReplyDTO.toString());
        consultReplyService.registerReply(consultReplyDTO);
        consultReplyService.registerMiddle(consultReplyDTO.getId(), (Long)session.getAttribute("id"), consultReplyDTO.getConsultingId());
    }

    //댓글조회
    @GetMapping("list/{consultingId}/{page}")
    public List<ConsultReplyDTO> getList(@PathVariable Long consultingId, @PathVariable Integer page){
        log.info(page+"");
        log.info(consultingId.toString());
        LecturePagination lecturePagination = new LecturePagination();
        lecturePagination.setPage(page);
        lecturePagination.setTotal(consultReplyService.getTotal(consultingId));
        lecturePagination.progress(5,5);
        return consultReplyService.getList(consultingId,lecturePagination);
    }


}
