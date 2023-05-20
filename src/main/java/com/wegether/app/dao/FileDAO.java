package com.wegether.app.dao;

<<<<<<< HEAD
import com.wegether.app.domain.vo.FileVO;
=======
import com.wegether.app.domain.dto.CommunityFileDTO;
>>>>>>> master
import com.wegether.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
<<<<<<< HEAD
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




=======

    private final FileMapper fileMapper;

    public List<CommunityFileDTO> findAll(Long communityId) { return fileMapper.selectAll(communityId); }

    public void save(CommunityFileDTO communityFileDTO) { fileMapper.insert(communityFileDTO);}
>>>>>>> master

}
