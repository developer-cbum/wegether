package com.wegether.app.controller;

import com.wegether.app.domain.dto.*;
import com.wegether.app.service.community.CommunityReplyService;
import com.wegether.app.service.consult.ConsultReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/community-replies/*")
public class CommunityReplyController {

    private final CommunityReplyService communityReplyService;

//    댓글 등록
    @PostMapping("register")
    @Transactional(rollbackFor = Exception.class)
    public void register(@RequestBody CommunityReplyDTO communityReplyDTO){
        log.info(communityReplyDTO.toString());
        communityReplyService.register(communityReplyDTO);
        communityReplyService.registerMiddle(communityReplyDTO.getId(), 1L , communityReplyDTO.getCommunityId());

    }

    //댓글조회
    @GetMapping("list/{communityId}/{page}")
    public List<CommunityReplyDTO> getList(@PathVariable Long communityId, @PathVariable Integer page){
        log.info(page+"");
        log.info(communityId.toString());
        CommunityPagination communityPagination = new CommunityPagination();
        communityPagination.setPage(page);
        communityPagination.setTotal(communityReplyService.getTotal(communityId));
        communityPagination.progress(5,5);
        return communityReplyService.getList(communityId,communityPagination);
    }


    @PutMapping("modify")
    public void modify(@RequestBody CommunityReplyDTO communityReplyDTO){
        communityReplyService.modify(communityReplyDTO);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id){
        communityReplyService.remove(id);
    }

}
