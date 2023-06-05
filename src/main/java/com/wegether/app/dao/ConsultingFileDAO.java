package com.wegether.app.dao;

import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.ConsultingFileVO;
import com.wegether.app.mapper.CommunityFileMapper;
import com.wegether.app.mapper.ConsultingFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConsultingFileDAO {

    private final ConsultingFileMapper consultingFileMapper;

    public void save(ConsultingFileVO consultingFileVO){consultingFileMapper.insert(consultingFileVO);}

    public void delete(Long consultingId) {consultingFileMapper.delete(consultingId);}
}
