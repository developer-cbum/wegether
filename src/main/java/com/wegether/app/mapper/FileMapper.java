package com.wegether.app.mapper;

import com.wegether.app.domain.dto.DataFileDTO;
import com.wegether.app.domain.vo.FileVO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    //    자료 파일 추가
    public void insert(DataFileDTO fileVO);

    //    자료 파일 조회
//    public FileVO select(Long id);
    public List<DataFileDTO> dataSelectAll(Long dataId);



    public void communityInsert(CommunityFileDTO fileVO);

    public List<CommunityFileDTO> communitySelectAll(Long communityId);

<<<<<<< HEAD
    //    파일 삭제
    public void delete(Long id);
=======
    public void communityDelete(Long id);
>>>>>>> 7db43bdc8918d5f84bcbd6bf6277e598800a8d7d

    public void communityDeleteAll(Long communityId);
}
