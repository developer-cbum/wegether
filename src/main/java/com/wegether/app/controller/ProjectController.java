package com.wegether.app.controller;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.domain.vo.ProjectVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.model.IAttribute;

import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectService projectService;
    private final AccountService accountService;


    @GetMapping("main")
    public void list(ProjectPagination projectPagination, Model model) {
        projectPagination.setTotal(projectService.getTotal());
        projectPagination.progress();
        model.addAttribute("project", projectService.getList(projectPagination));
    }

    @GetMapping("write")
    public void goToRegisterForm(ProjectDTO projectDTO, Model model){;}

    @PostMapping("write")
    public RedirectView register(ProjectDTO projectDTO){
        projectService.write(projectDTO);
        return new RedirectView("/project/studio/write/baseinfo");
    }



    @GetMapping("modify")
    public void goToProjectModify(@RequestParam Long id, Model model){
        model.addAttribute("project", projectService.getProject(id).get());
    }

    @GetMapping("detail")
    public void goToProjectDetail(@RequestParam Long id, Model model){
        model.addAttribute("project", projectService.getProject(id).get());
        log.info(projectService.getProject(1L).toString());
    }

    @PostMapping("modify")
    public RedirectView modify(ProjectDTO projectDTO, RedirectAttributes redirectAttributes){
        log.info(projectDTO.toString());
        projectService.modify(projectDTO);
        redirectAttributes.addAttribute("id", projectDTO.getId());
        return new RedirectView("/project/detail");
    }

    @GetMapping("register")
    public void goToRegisterForm(ProjectVO projectVO, HttpSession session, Model model) {

        String nickName = accountService.getMemberById((Long) session.getAttribute("id")).get().getMemberNickname();
        model.addAttribute("nickName", nickName);
    }
}





















