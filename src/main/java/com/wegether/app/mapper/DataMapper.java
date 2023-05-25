package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.InquiryDTO;
import com.wegether.app.domain.dto.DataPagination;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.type.CategoryType;
import com.wegether.app.domain.vo.DataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DataMapper {

    //    자료 목록 조회
    public List<DataDTO> selectAll(@Param("dataPagination") DataPagination dataPagination, @Param("categoryType") CategoryType categoryType);

//    자료 목록 조회
//    public List<DataDTO> selectAll(@Param("dataPagination") DataPagination dataPagination);


    //    자료 추가
    public void insert(DataDTO dataDTO);

    //    자료 상세 조회
    public Optional<DataDTO> select(Long id);
    //    조회수 증가
    public void updateCount(Long id);





















    //    소영 마이페이지 (내가 등록한 자료 / 내가 구매한 자료 조회)

//    게시글 총 개수
    public int selectCountOfData();

    //    내가 등록한 자료 조회
    public List<DataDTO> selectmydata(Long memberId);


}
