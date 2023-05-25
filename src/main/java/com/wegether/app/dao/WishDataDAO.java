package com.wegether.app.dao;

import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.mapper.WishDataMapper;
import com.wegether.app.mapper.WishProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WishDataDAO {

    private final WishDataMapper wishDataMapper;

    public List<DataDTO> showwishData(Long memberId){
        return wishDataMapper.selectAll(memberId);
    }
}
