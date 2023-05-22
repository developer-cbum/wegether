package com.wegether.app.service.lecture;

import com.wegether.app.domain.dto.LectureDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.Pagination;

import java.util.List;

public interface LectureService {

    public void write(LectureDTO lectureDTO);


    //강연 게시글 목록
    public List<LectureDTO> getList(LecturePagination lecturePagination);

    //강연 총 개수
    public int getTotal();


}
