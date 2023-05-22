package com.wegether.app.controller;


import com.wegether.app.domain.dto.LectureDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admins/*")
@RequiredArgsConstructor
public class AdminLectureController {


    @GetMapping("lecture/register")
    public void goTOregisterFrom(LectureDTO lectureDTO){;}

    @PostMapping("lecture/register")
    public void register(LectureDTO lectureDTO){


    }

}
