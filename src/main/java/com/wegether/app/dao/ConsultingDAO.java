package com.wegether.app.dao;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.mapper.ConsultingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConsultingDAO {
    private final ConsultingMapper consultingMapper;

    // 상담 추가
    public void saveConsulting(ConsultingVO consultingVO){
        consultingMapper.insertConsulting(consultingVO);
    }

    // 상담목록
    public List<ConsultingDTO> findAll(Pagination pagination, Search search){
       return consultingMapper.selectAll(pagination, search);
    }

    //상담 총 개수
    public int findCountOfConsulting(Search search){
      return consultingMapper.selectCountOfConsulting(search);
    }

    // 상담 상세
    public Optional<ConsultingDTO> findConsulting(Long id){
        return consultingMapper.selectConsulting(id);
    }

    // 상담 수정
    public void setConsulting(ConsultingDTO ConsultingDTO){
        consultingMapper.updateConsulting(ConsultingDTO);
    }

    // 상담 삭제
    public void deleteConsulting(Long id){
        consultingMapper.deleteConsulting(id);
    }



}
