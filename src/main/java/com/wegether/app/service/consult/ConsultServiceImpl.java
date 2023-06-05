package com.wegether.app.service.consult;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.dao.ConsultingFileDAO;
import com.wegether.app.dao.ConsultingReplyDAO;
import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.ConsultingFileVO;
import com.wegether.app.domain.vo.ConsultingReplyVO;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl implements ConsultService {

    private final ConsultingDAO consultingDAO;
    private final ConsultingReplyDAO consultReplyDAO;
    private final FileDAO fileDAO;
    private final ConsultingFileDAO consultingFileDAO;

    //상담 등록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(ConsultingDTO consultingDTO) {
        consultingDAO.saveConsulting(consultingDTO);
        consultingDTO.getFiles().forEach(file -> {
            if(file.getFileType() == null) {
                file.setFileType(FileType.NON_REPRESENTATIVE.name());
            }
            file.setConsultingId(consultingDTO.getId());
            fileDAO.consultingSave(file);
        });
        consultingDTO.getFiles().forEach(consultingFileDTO ->
        { ConsultingFileVO consultingFileVO = new ConsultingFileVO();
            consultingFileVO.setId(consultingFileDTO.getId());
            consultingFileVO.setConsultingId(consultingFileDTO.getConsultingId());
            consultingFileDAO.save(consultingFileVO);
        });

    }
    //상담 조회
    @Override
    public List<ConsultingDTO> getList(Pagination pagination, Search search) {
        //        게시글 전체 목록
        final List<ConsultingDTO> consultingDTOS = consultingDAO.findAll(pagination, search);
//        게시글 하나씩 첨부파일 목록 담기
        consultingDTOS.forEach(consultingDTO -> consultingDTO.setFiles(fileDAO.consultingFindAll(consultingDTO.getId())));
        return consultingDTOS;
    }

    // 총 개수
    @Override
    public int getTotal(Search search) {
        return consultingDAO.findCountOfConsulting(search);
    }

    //상담 상세
    @Override
    public Optional<ConsultingDTO> getConsulting(Long id) {

        final Optional<ConsultingDTO> foundPost = consultingDAO.findConsulting(id);
        if(foundPost.isPresent()){
            foundPost.get().setFiles(fileDAO.consultingFindAll(foundPost.get().getId()));
        }
        return foundPost;
    }

    // 상담 수정
    @Override
    public void modifyConsulting(ConsultingDTO consultingDTO) {

        consultingDAO.setConsulting(consultingDTO);

        consultingDTO.getFiles().forEach(file -> {
            if(file.getFileType() == null) {
                file.setFileType(FileType.NON_REPRESENTATIVE.name());
            }
            file.setConsultingId(consultingDTO.getId());
            fileDAO.consultingSave(file);
        });
        consultingDTO.getFiles().forEach(consultingFileDTO ->
        { ConsultingFileVO consultingFileVO = new ConsultingFileVO();
            consultingFileVO.setId(consultingFileDTO.getId());
            consultingFileVO.setConsultingId(consultingFileDTO.getConsultingId());
            consultingFileDAO.save(consultingFileVO);
        });

        consultingDTO.getFileIdsForDelete().forEach(fileDAO::consultingDelete);
    }

    // 상담 삭제
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeConsulting(Long id) {
        List<ConsultingReplyVO> middleAlls = consultReplyDAO.findMiddleAll(id);
        //중간테이블 전체삭제 (댓글)
        consultReplyDAO.deleteMiddleAll(id);
        // 중간테이블 파일
        consultingFileDAO.delete(id);
        // 파일테이블 파일 삭제
        fileDAO.consultingDelete(id);
        //댓글 전체삭제
       middleAlls.forEach(middleAll -> consultReplyDAO.deleteReply(middleAll.getId()));
       //게시글삭제
        consultingDAO.deleteConsulting(id);
    }


}
