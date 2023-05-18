package com.wegether.app.domain.dto;

import com.wegether.app.domain.vo.FileVO;

import java.util.ArrayList;
import java.util.List;

public class DataDTO {
    private Long id;
    private Long memberId;
    private String dataTitle;
    private String dataContent;
    private String dataPrice;
    private String dataSchool;
    private String dataMajor;
    private Long dataReadCount;
    private String dataRegisterDate;
    private String dataUpdateDate;
    private List<FileVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
