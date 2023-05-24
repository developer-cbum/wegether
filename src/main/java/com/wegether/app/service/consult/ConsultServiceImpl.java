package com.wegether.app.service.consult;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.dao.ConsultingReplyDAO;
import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
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

    //상담 등록
    @Override
    public void register(ConsultingVO consultingVO) {
        consultingDAO.saveConsulting(consultingVO);
    }
    //상담 조회
    @Override
    public List<ConsultingDTO> getList(Pagination pagination, Search search) {
        return consultingDAO.findAll(pagination, search);
    }

    // 총 개수
    @Override
    public int getTotal(Search search) {
        return consultingDAO.findCountOfConsulting(search);
    }

    //상담 상세
    @Override
    public Optional<ConsultingDTO> getConsulting(Long id) {
        return consultingDAO.findConsulting(id);
    }

    // 상담 수정
    @Override
    public void modifyConsulting(ConsultingDTO consultingDTO) {
        consultingDAO.setConsulting(consultingDTO);
    }

    // 상담 삭제
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeConsulting(Long id) {
        List<ConsultingReplyVO> middleAlls = consultReplyDAO.findMiddleAll(id);
        //중간테이블 전체삭제
        consultReplyDAO.deleteMiddleAll(id);
        //댓글 전체삭제
       middleAlls.forEach(middleAll -> consultReplyDAO.deleteReply(middleAll.getId()));
       //게시글삭제
        consultingDAO.deleteConsulting(id);
    }


}
