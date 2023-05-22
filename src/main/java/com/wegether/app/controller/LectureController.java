package com.wegether.app.controller;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.service.lecture.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

     //상세
    @GetMapping("detail")
    public void goToDetail(@RequestParam Long id, Model model){
        model.addAttribute("lecture",lectureService.get(id).get());
    }

    // 등록폼가기
    @GetMapping("register")
    public void goToRegisterForm(LectureDTO lectureDTO){;}

    //등록하기
    @PostMapping("register")
    public RedirectView register(LectureDTO lectureDTO){
        lectureService.register(lectureDTO);
        return new RedirectView("/admins/lecture/list");
    }
}

