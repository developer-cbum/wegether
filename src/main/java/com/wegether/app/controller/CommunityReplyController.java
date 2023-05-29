package com.wegether.app.controller;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.CommunityReplyVO;
import com.wegether.app.domain.vo.CommunityVO;
import com.wegether.app.service.community.CommunityReplyService;
import com.wegether.app.service.consult.ConsultReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community-replies/*")
public class CommunityReplyController {

    private final CommunityReplyService communityReplyService;
    private final HttpSession session;

//    댓글 등록

    @PostMapping("register")
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> register(@RequestBody CommunityReplyDTO communityReplyDTO, Model model){
        log.info(communityReplyDTO.toString());
        communityReplyService.register(communityReplyDTO);
        CommunityReplyVO communityReplyVO = new CommunityReplyVO();
        communityReplyVO.setId(communityReplyDTO.getId());
        communityReplyVO.setMemberId((Long)session.getAttribute("id"));
        communityReplyVO.setCommunityId(communityReplyDTO.getCommunityId());
        communityReplyService.registerMiddle(communityReplyVO);
        List<Integer> totals = new ArrayList<>();
        totals.add(0, communityReplyService.getTotal(communityReplyDTO.getCommunityId()));
        totals.add(1, communityReplyService.getTotalOfReply(communityReplyDTO.getCommunityId()));
        return totals;
}

    //댓글조회
    @GetMapping("list/{communityId}/{page}")
    public List<CommunityReplyDTO> getList(@PathVariable Integer page, @PathVariable Long communityId){
        CommunityPagination communityPagination = new CommunityPagination();
        communityPagination.setPage(page);
        communityPagination.setTotal(communityReplyService.getTotal(communityId));
        communityPagination.progress(5, 5);
        return communityReplyService.getList(communityId, communityPagination);
    }

    //대댓글 등록
    @PostMapping("register-again")
    @Transactional(rollbackFor = Exception.class)
    public int registerAgain(@RequestBody CommunityReplyDTO communityReplyDTO){
        log.info("대댓글 컨트롤러");
        communityReplyService.registerDepth(communityReplyDTO);
        log.info("==================" + communityReplyDTO.getId().toString());
        CommunityReplyVO communityReplyVO = new CommunityReplyVO();
        log.info(communityReplyDTO.toString());
        log.info(communityReplyDTO.getId().toString());
        communityReplyVO.setId(communityReplyDTO.getId());
        communityReplyVO.setCommunityId(communityReplyDTO.getCommunityId());
        communityReplyVO.setMemberId((Long)session.getAttribute("id"));
        log.info("=================" + communityReplyVO.toString());
        communityReplyService.registerMiddle(communityReplyVO);
        return communityReplyService.getTotal(communityReplyDTO.getCommunityId());
    }

    //대댓글조회
    @GetMapping("again-list/{communityId}")
    public  List<CommunityReplyDTO> getListAgain(@PathVariable  Long communityId){
        return communityReplyService.getListAgain(communityId);
    }

//    댓글 삭제
//댓글 삭제
@DeleteMapping("remove/{id}")
@Transactional(rollbackFor = Exception.class)
public List<Integer> removeReply(@PathVariable Long id){
    Long num = communityReplyService.getMiddle(id).get().getCommunityId();
    List<Integer> totals = new ArrayList<>();
    //일반 댓글일때
    if(communityReplyService.getReply(id).get().getReplyDepth()== 0){
        //대댓글 집합
        List<CommunityReplyDTO> replyAgains = communityReplyService.getAgain(id);
        //그 댓글에 해당되는 중간테이블 삭제
        if(replyAgains.size() > 0) {
            //중간 테이블 대댓글 전체삭제
            replyAgains.stream().filter(communityReplyDTO -> communityReplyDTO.getReplyGroup() == id)
                    .forEach(communityReplyDTO -> communityReplyService.removeMiddle(communityReplyDTO.getId()));
            //대댓글 모두삭제
            replyAgains.stream().filter(communityReplyDTO -> communityReplyDTO.getReplyGroup() == id )
                    .forEach(communityReplyDTO -> communityReplyService.remove(communityReplyDTO.getId()));
            //그리고 그냥 댓글삭제과 중간댓글삭제[
            communityReplyService.removeMiddle(id);
            communityReplyService.remove(id);

        } else{
            log.info("3들어옴");
            communityReplyService.removeMiddle(id);
            communityReplyService.remove(id);
            totals.add(0, communityReplyService.getTotal(num));
            totals.add(1, communityReplyService.getTotal(num));
            return totals;
        }

    } else{
//            대댓글일때
        log.info("들어옴");
        communityReplyService.removeMiddle(id);
        communityReplyService.remove(id);
        totals.add(0, communityReplyService.getTotal(num));
        totals.add(1, communityReplyService.getTotal(num));
        return totals;
    }
    totals.add(0, communityReplyService.getTotal(num));
    totals.add(1, communityReplyService.getTotal(num));
    return totals;

}


    @PutMapping("modify")
    public void modify(@RequestBody CommunityReplyDTO communityReplyDTO){
        communityReplyService.modify(communityReplyDTO);
    }


}
