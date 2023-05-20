package com.wegether.app.mapper.consultings;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.mapper.ConsultingMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class consultingMapperTests {

    @Autowired
    private ConsultingMapper consultingMapper;

    // 컨설팅 등록
    @Test
    public void insertConsultingTest(){
        ConsultingVO consultingVO = new ConsultingVO();
        consultingVO.setMemberId(1L);
        consultingVO.setConsultingTitle("고려대가고싶어요");
        consultingVO.setConsultingContent("어떻게하죠?");
        consultingVO.setConsultingCategory("진로");

        consultingMapper.insertConsulting(consultingVO);
    }

    //상담 조회
    @Test
    public void selectAllTest(){
        Pagination pagination = new Pagination();
        Search search = new Search();
        pagination.setPage(1);
        pagination.progress();
<<<<<<< HEAD
//        List<ConsultingDTO> consultingDTOS = consultingMapper.selectAll(pagination);
//        consultingDTOS.stream().map(consultingDTO -> consultingDTO.toString()).forEach(log::info);
=======
        List<ConsultingDTO> consultingDTOS = consultingMapper.selectAll(pagination, search);
        consultingDTOS.stream().map(consultingDTO -> consultingDTO.toString()).forEach(log::info);
>>>>>>> master
    }

    //총 개수
    @Test
    public void selectCountOfConsultingTests(){
<<<<<<< HEAD
//        int total = consultingMapper.selectCountOfConsulting();
//        log.info(String.valueOf(total));
=======
        Search search = new Search();
        int total = consultingMapper.selectCountOfConsulting(search);
        log.info(String.valueOf(total));
>>>>>>> master
    }

    //상담 상세
    @Test
    public void selectConsultTest(){
        log.info(consultingMapper.selectConsulting(90L).toString());
    }

    //상담 수정
    @Test
    public void updateTest(){
<<<<<<< HEAD
//        ConsultingDTO consultingDTO = consultingMapper.selectConsulting(1L);
//        consultingDTO.setConsultingTitle("안녕3");
//        consultingMapper.updateConsulting(consultingDTO);
//        log.info(consultingDTO.toString());
=======
        Optional<ConsultingDTO> consultingDTO = consultingMapper.selectConsulting(1L);
        consultingDTO.get().setConsultingTitle("안녕3");
        consultingMapper.updateConsulting(consultingDTO.get());
        log.info(consultingDTO.toString());
>>>>>>> master
    }

}
