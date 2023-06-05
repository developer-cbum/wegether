package com.wegether.app.mapper;

import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.ConsultingFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsultingFileMapper {
    public void insert(ConsultingFileVO consultingFileVO);

    public void delete(Long consultingId);
}
