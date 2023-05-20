package com.wegether.app.mapper;

import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    //    파일 추가
    public void insert(FileVO fileVO);

    //    파일 삭제
    public void delete(Long id);

    //    파일 조회
    public FileVO select(Long id);



    public void insert(CommunityFileDTO fileVO);

    public List<CommunityFileDTO> selectAll(Long communityId);


    public void deleteAll(Long communityId);
}
