package com.wegether.app.dao;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.DataPagination;
import com.wegether.app.domain.type.CategoryType;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.mapper.DataMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DataDAO {
    private final DataMapper dataMapper;

    //    자료 목록
    public List<DataDTO> findAll(DataPagination dataPagination, CategoryType categoryType){
        return dataMapper.selectAll(dataPagination, categoryType);
    }

    //    자료 추가
    public void save(DataDTO dataDTO){
        dataMapper.insert(dataDTO);
    }

    //    자료 조회
    public Optional<DataDTO> findById(Long id){
        return dataMapper.select(id);
    }
    //    조회수 증가
    public void viewCountUp(Long id) {dataMapper.updateCount(id);}


    //    게시글 총 개수
    public int findCountOfData(){
        return dataMapper.selectCountOfData();
    }


//    결제 페이지
    public Optional<DataDTO> findByIdDataPay(Long id){
        return dataMapper.selectPay(id);
    }


// 자료 수정
    public void setData(DataDTO dataDTO){
        dataMapper.updateData(dataDTO);
    }
    //    찜하기
    public void saveWish(Long memberId, Long dataId){
        dataMapper.insertWish(memberId, dataId);
    }
    //    찜하기 취소
    public void deleteWish(Long memberId, Long dataId){
        dataMapper.deleteWish(memberId, dataId);
    }
    //    내가 찜한 자료 검사
    public Long findWishId(Long memberId, Long dataId){
        return dataMapper.selectWish(memberId, dataId);
    }











    










//    소영 마이페이지 내가 등록한 자료 조회
    public List<DataDTO> showmydata(Long memberId){return dataMapper.selectmydata(memberId);}

}
