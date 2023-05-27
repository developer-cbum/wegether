package com.wegether.app.service.lecture;

import com.wegether.app.dao.FileDAO;
import com.wegether.app.dao.LectureDAO;
import com.wegether.app.dao.LectureFileDAO;
import com.wegether.app.dao.LectureMemberDAO;
import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.LectureFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureDAO lectureDAO;
    private final LectureFileDAO lectureFileDAO;
    private final FileDAO fileDAO;

    //강연등록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(LectureDTO lectureDTO) {
        lectureDAO.save(lectureDTO);
//        위에는 file 테이블 등록
        for (int i = 0; i < lectureDTO.getFiles().size(); i++) {
            lectureDTO.getFiles().get(i).setLectureId(lectureDTO.getId());
            lectureDTO.getFiles().get(i).setFileType(i == 0 ? FileType.REPRESENTATIVE.name() : i == 1 ? FileType.NON_REPRESENTATIVE.name() : FileType.CONTENT_REPRESENTATIVE.name());
            lectureFileDAO.save(lectureDTO.getFiles().get(i));
        }
        log.info(lectureDTO.getFiles().toString());

        lectureDTO.getFiles().forEach(lectureFileDTO ->
        { LectureFileVO lectureFileVO = new LectureFileVO();
            lectureFileVO.setId(lectureFileDTO.getId());
            lectureFileVO.setLectureId(lectureFileDTO.getLectureId());
            lectureFileDAO.saveMiddle(lectureFileVO);
        });
    }



    @Override
    public int getTotal() {
        return lectureDAO.findCountOfLecture();
    }

    //    자료 목록 - 파일
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<LectureDTO> getList(LecturePagination lecturePagination) {
        //        게시글 전체 목록
        final List<LectureDTO> lists = lectureDAO.findAll(lecturePagination);
        //        게시글 하나씩 첨부파일 목록 담기
        lists.forEach(list -> list.setFiles(lectureFileDAO.lectureFindAll(list.getId())));
        return lists;
    }

    @Override
    public Optional<LectureDTO> get(Long id) {
        Optional<LectureDTO> lectureDTO = lectureDAO.find(id);
        lectureDTO.get().setFiles(lectureFileDAO.lectureFindAll(lectureDTO.get().getId()));
        return lectureDTO;
    }
}