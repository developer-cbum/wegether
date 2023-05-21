package com.wegether.app.dao;

import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

//        파일 조회
//    public void find(Long id){
//        fileMapper.select(id);
//    }


    public List<DataFileDTO> dataFindAll(Long dataId) { return fileMapper.dataSelectAll(dataId); }

//        파일 추가
    public void save(DataFileDTO dataFileDTO){
        fileMapper.insert(dataFileDTO);
    }

//       파일 삭제
    public void delete(Long id){
        fileMapper.delete(id);
    }






//    public List<CommunityFileDTO> findAll(Long communityId) { return fileMapper.selectAll(communityId); }

    public List<CommunityFileDTO> communityFindAll(Long communityId) { return fileMapper.communitySelectAll(communityId); }

    public void communitySave(CommunityFileDTO communityFileDTO) { fileMapper.communityInsert(communityFileDTO);}

    public void communityDelete(Long id){ fileMapper.communityDelete(id);}

    public void communityDeleteAll(Long communityId) { fileMapper.communityDeleteAll(communityId);}
}
