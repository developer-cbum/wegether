package com.wegether.app.service.lecture;

import com.wegether.app.dao.LectureDAO;
import com.wegether.app.dao.LectureFileDAO;
import com.wegether.app.dao.LectureMemberDAO;
import com.wegether.app.domain.dto.LectureDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureDAO lectureDAO;
    private final LectureMemberDAO lectureMemberDAO;
    private final LectureFileDAO lectureFileDAO;

    //강연등록
    @Override
    public void write(LectureDTO lectureDTO) {
        lectureDAO.save(lectureDTO);

    }
}