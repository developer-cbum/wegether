package com.wegether.app.dao;

import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.mapper.ConsultingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConsultingDAO {
    private final ConsultingMapper consultingMapper;

    public void saveConsulting(ConsultingVO consultingVO){
        consultingMapper.insertConsulting(consultingVO);
    }

}
