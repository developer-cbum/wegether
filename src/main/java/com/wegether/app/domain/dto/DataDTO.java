package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.FileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class DataDTO {
    private Long id;
    private Long memberId;
    private String dataTitle;
    private String dataContent;
    private Long dataPrice;
    private String dataSchool;
    private String dataMajor;
    private Long dataReadCount;
    private String dataRegisterDate;
    private String dataUpdateDate;
    private String memberNickname;
    private String memberSchool;
    private String memberMajor;
    private String memberIntroducing;
    private Long dataId;
//    private Long WishDataId;
//    private List<FileVO> files = new ArrayList<>();
    private List<DataFileDTO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();



    private String info;

    String order;

}
