package com.wegether.app.dao;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.mapper.ConsultingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConsultingDAO {
    private final ConsultingMapper consultingMapper;

    // 상담 추가
    public void saveConsulting(ConsultingVO consultingVO){
        consultingMapper.insertConsulting(consultingVO);
    }

    // 상담목록
    public List<ConsultingDTO> findAll(Pagination pagination){
       return consultingMapper.selectAll(pagination);
    }

    //상담 총 개수
    public int findCountOfConsulting(){
      return consultingMapper.selectCountOfConsulting();
    }


}
