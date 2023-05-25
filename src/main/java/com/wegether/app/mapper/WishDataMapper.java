package com.wegether.app.mapper;

import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.WishDataVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishDataMapper {
    //    찜하기
    public void insert(WishDataVO wishDataVO);
    //    찜삭제
    public void delete(Long id);

    //    찜 조회
    public List<DataDTO> selectAll(Long memberId);
}
