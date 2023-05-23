package com.wegether.app.mapper;

import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.WishProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishProjectMapper {
//    찜하기
    public void insert(WishProjectVO wishProjectVO);
//    찜삭제
    public void delete(Long id);
//    찜 조회
    public List<ProjectDTO> selectAll(Long memberId);

}
