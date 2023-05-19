package com.wegether.app.service.consult;

import com.wegether.app.dao.ConsultingDAO;
import com.wegether.app.domain.vo.ConsultingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl implements ConsultService {

    private final ConsultingDAO consultingDAO;

    @Override
    public void register(ConsultingVO consultingVO) {
        consultingDAO.saveConsulting(consultingVO);
    }
}
