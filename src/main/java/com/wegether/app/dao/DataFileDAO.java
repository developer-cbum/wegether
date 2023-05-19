package com.wegether.app.dao;

import com.wegether.app.domain.vo.DataFileVO;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.mapper.DataFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DataFileDAO {
    private final DataFileMapper dataFileMapper;

    //   file list
    public List<DataFileVO> findDataFiles(Long dataId) {
        return dataFileMapper.selectAll(dataId);
    };

    //    파일 조회
    public List<DataFileVO> findById(Long dataId){
        return dataFileMapper.selectAll(dataId);
    }

    //    파일 추가
    public void save(FileVO fileVO){
        dataFileMapper.insert(fileVO);
    }

    //    파일 삭제
    public void delete(Long id){
        dataFileMapper.delete(id);
    }

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long dataId){
        dataFileMapper.deleteAll(dataId);
    }


}