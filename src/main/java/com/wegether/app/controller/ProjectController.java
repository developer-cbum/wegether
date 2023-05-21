package com.wegether.app.controller;

import com.wegether.app.domain.dto.ProjectPagination;
import com.wegether.app.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IAttribute;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("list")
    public void list(ProjectPagination projectPagination, Model model) {
        projectPagination.progress();
        model.addAttribute("projects", projectService.getList(projectPagination));
    }

//    @GetMapping
//    public void
//
}





















