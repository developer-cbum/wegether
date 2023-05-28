package com.wegether.app.mapper;

import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.vo.DataFileVO;
import com.wegether.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataFileMapper {
//   파일 전체 조회
    public List<DataFileVO> selectAll(Long dataId);

    //    파일 조회
    public DataFileVO select(Long id);

    //    파일 추가
    public void insert(DataFileVO dataFileVO);

    //    게시글의 파일 삭제
    public void delete(Long id);


    //    게시글의 파일 전체 삭제
    public void deleteAll(Long dataId);

//    자료 파일 추가
    public void dataImageInsert(DataFileDTO dataFileDTO);

}
