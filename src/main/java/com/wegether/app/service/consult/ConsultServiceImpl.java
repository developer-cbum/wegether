package com.wegether.app.service.consult;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl implements ConsultService {

    private final ConsultingDAO consultingDAO;

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
    public void removeConsulting(Long id) {
        consultingDAO.deleteConsulting(id);
    }
}
