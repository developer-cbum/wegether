package com.wegether.app.mapper;

import com.wegether.app.domain.vo.ConsultingVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsultingMapper {
    //상담등록
    public void insertConsulting(ConsultingVO consultingVO);
}
