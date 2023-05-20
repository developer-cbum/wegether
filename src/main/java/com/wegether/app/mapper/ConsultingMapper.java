package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.ConsultingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsultingMapper {
    //상담등록
    public void insertConsulting(ConsultingVO consultingVO);

    //상담 게시글 목록
    public List<ConsultingDTO> selectAll(Pagination pagination);

    //상담 총 개수
    public int selectCountOfConsulting();


}
