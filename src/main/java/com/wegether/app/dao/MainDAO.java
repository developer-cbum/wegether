package com.wegether.app.dao;


import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MainDAO {
    private final MainMapper mainMapper;

    //    게시글 목록
    public List<MainDTO> ProjectfindAll(Pagination pagination, Search search){
        return mainMapper.ProjectSelectAll(pagination, search);
    }


    //    게시글 총 개수
    public int findCountOfPost(Search search){
        return mainMapper.selectCountOfProject(search);
    }









}

