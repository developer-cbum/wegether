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
    public int write(@RequestBody CommunityReplyDTO communityReplyDTO){
        communityReplyService.register(communityReplyDTO);
        return communityReplyService.getTotal(communityReplyDTO.getCommunityId());
}

    //댓글조회
    @GetMapping("list/{communityId}/{page}")
    public List<CommunityReplyDTO> getList(@PathVariable Integer page, @PathVariable Long communityId){
        final CommunityPagination communityPagination = new CommunityPagination();
        communityPagination.setPage(page);
        communityPagination.setTotal(communityReplyService.getTotal(communityId));
        communityPagination.progress(1, 10);
        log.info("================" + communityReplyService.getList(communityId, communityPagination).toString());
        return communityReplyService.getList(communityId, communityPagination);
    }

    //대댓글조회
    @GetMapping("again-list/{communityId}")
    public  List<CommunityReplyDTO> getListAgain(@PathVariable  Long communityId){
        return communityReplyService.getListAgain(communityId);
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
