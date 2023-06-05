package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.dto.Search;
import com.wegether.app.domain.vo.ConsultingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ConsultingMapper {
    //상담등록
    public void insertConsulting(ConsultingDTO consultingDTO);

    //상담 게시글 목록
    public List<ConsultingDTO> selectAll(@Param("pagination") Pagination pagination, @Param ("search")Search search);

    //상담 총 개수
    public int selectCountOfConsulting(@Param("search") Search search);

    // 상담 상세
    public Optional<ConsultingDTO> selectConsulting(Long id);

    // 상담 수정
    public void updateConsulting(ConsultingDTO consultingDTO);

    // 상담 삭제
    public void deleteConsulting(Long id);











//    소영 마이페이지 내 상담 조회

    public List<ConsultingVO> selectmyconsult(Long memberId);
}
