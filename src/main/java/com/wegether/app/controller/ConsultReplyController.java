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
    public int register(@RequestBody ConsultReplyDTO consultReplyDTO, Model model){
        log.info(consultReplyDTO.toString());
        consultReplyService.registerReply(consultReplyDTO);
        log.info(consultReplyDTO.getId().toString());
        consultReplyService.registerMiddle(consultReplyDTO.getId(), (Long)session.getAttribute("id"), consultReplyDTO.getConsultingId());
        return consultReplyService.getTotal(consultReplyDTO.getConsultingId());
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
    public int registerAgain(@RequestBody ConsultReplyDTO consultReplyDTO){
        log.info("대댓글 컨트롤러");
        log.info(consultReplyDTO.toString());
        consultReplyService.registerReplyAgain(consultReplyDTO);
        log.info(consultReplyDTO.getId().toString());
        consultReplyService.registerMiddle(consultReplyDTO.getId(), (Long)session.getAttribute("id"), consultReplyDTO.getConsultingId());
        return consultReplyService.getTotal(consultReplyDTO.getConsultingId());
    }

    //대댓글조회
    @GetMapping("again-list/{consultingId}")
    public  List<ConsultReplyDTO> getListAgain(@PathVariable  Long consultingId){
        return consultReplyService.getListAgain(consultingId);
    }

    //댓글 삭제
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("remove/{id}")
    public int removeReply(@PathVariable Long id){
      Long num = consultReplyService.getMiddle(id).get().getConsultingId();
        log.info("1들어옴");
        //일반 댓글일때
        if(consultReplyService.get(id).get().getReplyDepth()== 0){
            log.info("2들어옴");
            //대댓글 집합
            List<ConsultReplyDTO> replyAgains = consultReplyService.getAgain();
            //그 댓글에 해당되는 중간테이블 삭제
            log.info(replyAgains.toString());
            if(replyAgains.size() > 1) {
                log.info("1보다크면들어옴들어옴");
                replyAgains.stream().filter(consultReplyDTO -> consultReplyDTO.getReplyGroup() == id)
                        .forEach(consultReplyDTO -> consultReplyService.removeMiddle(consultReplyDTO.getId()));
                //댓글에 해당되는 대댓글 전체삭제
                replyAgains.stream().filter(consultReplyDTO -> consultReplyDTO.getReplyGroup() == id)
                        .forEach(consultReplyDTO -> consultReplyService.removeReply(consultReplyDTO.getId()));
            } else{
                log.info("3들어옴");
                consultReplyService.removeMiddle(id);
            }
            log.info("4들어옴");
            consultReplyService.removeReply(id);
            return consultReplyService.getTotal(num);
        } else{
//            대댓글일때
            consultReplyService.removeMiddle(id);
            consultReplyService.removeReply(id);
            return consultReplyService.getTotal(num);
        }

    }




}

