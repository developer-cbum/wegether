package com.wegether.app.service.consult;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;

import java.util.List;
import java.util.Optional;

public interface ConsultService {
    //등록
    public void register(ConsultingVO consultingVO);

    // 목록
    public List<ConsultingDTO> getList(Pagination pagination, Search search);

    // 총개수
    public int getTotal(Search search);

    // 상담 상세
    public Optional<ConsultingDTO> getConsulting(Long id);

    // 상담 수정
    public void modifyConsulting(ConsultingDTO consultingDTO);

    // 상담 삭제
    public void removeConsulting(Long id);
}




















