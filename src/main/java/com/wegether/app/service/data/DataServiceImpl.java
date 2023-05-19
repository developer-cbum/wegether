package com.wegether.app.service.data;

import com.wegether.app.dao.DataDAO;
import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataDAO dataDAO;
    private final FileDAO fileDAO;
//    private final WishDataDAO wishDataDAO;


    @Override
    public List<DataDTO> getList(Pagination pagination) {
        return null;
    }

    @Override
    public void write(DataDTO postDTO) {

    }

    @Override
    public Optional<DataDTO> read(Long id) {
        return Optional.empty();
    }
}
