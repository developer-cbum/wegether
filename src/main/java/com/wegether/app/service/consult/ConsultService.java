package com.wegether.app.service.consult;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.ConsultingVO;

import java.util.List;

public interface ConsultService {
    //등록
    public void register(ConsultingVO consultingVO);

    // 목록
    public List<ConsultingDTO> getList(Pagination pagination);

    // 총개수
    public int getTotal();

    // 상담 상세
    public ConsultingDTO getConsulting(Long id);

    // 상담 수정
    public void modifyConsulting(ConsultingDTO consultingDTO);

}




















