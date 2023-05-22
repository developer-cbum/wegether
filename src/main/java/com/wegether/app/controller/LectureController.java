package com.wegether.app.controller;

import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.service.lecture.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lectures/*")
@RequiredArgsConstructor
@Slf4j
public class LectureController {

    final private LectureService lectureService;

    @GetMapping("main")
    public void goToMain(LecturePagination lecturePagination, Model model){
        lecturePagination.setTotal(lectureService.getTotal());
        lecturePagination.progress(5,5);
        model.addAttribute("lists", lectureService.getList(lecturePagination));
        }
}

