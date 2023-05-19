package com.wegether.app.dao;

import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

//        파일 조회
    public void find(Long id){
        fileMapper.select(id);
    }

//        파일 추가
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

//       파일 삭제
    public void delete(Long id){
        fileMapper.delete(id);
    }





}
