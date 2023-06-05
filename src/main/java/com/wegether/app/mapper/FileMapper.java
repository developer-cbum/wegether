package com.wegether.app.mapper;

import com.wegether.app.domain.dto.*;
import com.wegether.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    //    자료 파일 추가
    public void insert(DataFileDTO fileVO);

//    05-22 이기철 추가
    public void projectInsert(ProjectFileDTO projectFileDTO);

    //    자료 파일 조회
//    public FileVO select(Long id);
    public List<DataFileDTO> dataSelectAll(Long dataId);

    public List<ProjectFileDTO> projectSelectAll(Long projectID);

    public void communityInsert(CommunityFileDTO fileVO);

    public List<CommunityFileDTO> communitySelectAll(Long communityId);


    //    파일 삭제
    public void delete(Long id);

    public void communityDelete(Long id);

    public void communityDeleteAll(Long communityId);

    public void projectDelete(Long id);


    // 상담


    public void consultingInsert(ConsultingFileDTO consultingFileDTO);

    public List<ConsultingFileDTO> consultingSelectAll(Long consultingId);

    public void consultingDelete(Long id);


}
