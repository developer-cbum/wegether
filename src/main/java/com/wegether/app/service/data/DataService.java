package com.wegether.app.service.data;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.DataFileVO;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.domain.vo.FileVO;

import java.util.List;
import java.util.Optional;


public interface DataService {
    //    게시글 목록
    public List<DataDTO> getList(DataPagination dataPagination);

    //    게시글 추가
    public void write(DataDTO dataDTO);

    //    게시글 조회
    public Optional<DataDTO> read(Long id);

    //    게시글 전체 개수 조회
    public int getTotal();







        //    게시글 수정
//    public void modify(DataDTO dataDTO);

    //    게시글 삭제
//    public void remove(Long id);

    default DataDTO toDTO(DataVO dataVO){
        DataDTO dataDTO = new DataDTO();
        dataDTO.setId(dataDTO.getId());
        dataDTO.setDataTitle(dataVO.getDataTitle());
        dataDTO.setDataContent(dataVO.getDataContent());
        dataDTO.setDataPrice(dataVO.getDataPrice());
        dataDTO.setDataSchool(dataVO.getDataSchool());
        dataDTO.setDataMajor(dataVO.getDataMajor());
        dataDTO.setDataReadCount(dataVO.getDataReadCount());
        dataDTO.setDataRegisterDate(dataVO.getDataRegisterDate());
        dataVO.setDataUpdateDate(dataVO.getDataUpdateDate());
        dataDTO.setMemberId(dataVO.getMemberId());

        return dataDTO;
    }

    default DataFileDTO toDTO(FileVO fileVO){
        DataFileDTO dataFileDTO = new DataFileDTO();
        dataFileDTO.setId(fileVO.getId());
        dataFileDTO.setFileName(fileVO.getFileName());
        dataFileDTO.setFileUuid(fileVO.getFileUuid());
        dataFileDTO.setFileSize(fileVO.getFileSize());
        dataFileDTO.setFilePath(fileVO.getFilePath());
        return dataFileDTO;
    }


}




















