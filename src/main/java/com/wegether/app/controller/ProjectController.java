package com.wegether.app.controller;


import com.wegether.app.domain.dto.AdminPagination;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.type.CategoryType;
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
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectService projectService;


    @GetMapping("write")
    public void goToRegisterForm(ProjectDTO projectDTO, Model model) {;}


    @PostMapping("write")
    public RedirectView register(ProjectDTO projectDTO) {
        projectDTO.setMemberId(4L);
        log.info(projectDTO.toString());
        projectService.write(projectDTO);
        return new RedirectView("/project/list");
    }

    // 프로젝트 목록
    @GetMapping(value = {"main", "list"})
    public List<ProjectDTO> list(Model model, ProjectPagination projectPagination){
        log.info(projectPagination.toString());
        projectPagination.setTotal(projectService.getProjectTotal());
        projectPagination.progress();
        model.addAttribute("projects", projectService.getList(projectPagination));
        return projectService.getList(projectPagination);
        
    }
    



//    @ResponseBody
//    @GetMapping("main")
//    public List<ProjectDTO> list(){
//        final ProjectPagination projectPagination = new ProjectPagination();
//        projectPagination.progress();
//        projectPagination.setTotal(projectService.getProjectTotal());
//        return projectService.getList(projectPagination);
//    }



//    @GetMapping("write")
//    public void goToRegisterForm(ProjectDTO projectDTO, Model model) {;}
//
//
//    @PostMapping("write")
//    public RedirectView register(ProjectDTO projectDTO) {
//        projectDTO.setMemberId((22L);
//        log.info(projectDTO.toString());
//        projectService.write(projectDTO);
//        return new RedirectView("/project/list");
//    }

    @GetMapping("detail")
    public void read(@RequestParam Long id, Model model, ProjectDTO projectDTO){
        model.addAttribute("projectDTO", projectService.read(id).get());
    }







//    @GetMapping("modify")
//    public void goToProjectModify(@RequestParam Long id, Model model){
//        model.addAttribute("project", projectService.getProject(id).get());
//    }


//    @PostMapping("modify")
//    public RedirectView modify(ProjectDTO projectDTO, RedirectAttributes redirectAttributes){
//        log.info(projectDTO.toString());
//        projectService.modify(projectDTO);
//        redirectAttributes.addAttribute("id", projectDTO.getId());
//        return new RedirectView("/project/detail");
//    }


}





















