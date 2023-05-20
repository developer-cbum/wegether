package com.wegether.app.service.data;

import com.wegether.app.dao.DataDAO;
import com.wegether.app.dao.DataFileDAO;
import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.ConsultingDTO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.ConsultingVO;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataDAO dataDAO;
    private final FileDAO fileDAO;
    private final DataFileDAO dataFileDAO;


//  자료 목록
    @Override
    public List<DataDTO> getList(Pagination pagination) {
        return dataDAO.findAll(pagination);
    }

//    자료 목록 - 파일
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public List<DataDTO> getList(Pagination pagination) {
////        게시글 전체 목록
//        final List<DataDTO> datas = dataDAO.findAll(pagination);
////        게시글 하나씩 첨부파일 목록 담기

//        final List<DataVO> dataFiles = dataFileDAO.findDataFiles(dataFileDAO.findDataFiles(dataId).toArray();

//        datas.forEach(data -> data.setFiles(data.getId()));
//        datas.stream().forEach(data -> {
//            dataFileDAO.findDataFiles(data.getId()).stream().map(DataFileDAO::getFileId)
//                    .forEach(fileId ->  data.getFiles().add(dataFileDAO.findById(dataId);));
//        });
//        return datas;
//    }


//  자료 등록
    @Override
    public void write(DataDTO dataDTO) {
        dataDAO.save(dataDTO);
    }


//    자료 등록 - 파일
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void write(DataDTO dataDTO) {
//        dataDAO.save(dataDTO);
//        dataDTO.getFiles().forEach(dataFile -> {
//            dataFile.setId(dataDTO.getId());
//            dataFileDAO.save(dataFile);
//        });
//    }


//    자료 조회 - 파일
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<DataDTO> read(Long id) {
        final Optional<DataDTO> foundData = dataDAO.findById(id);
//        if(foundData.isPresent()){
//            foundData.get().setFiles(dataFileDAO.findById(foundData.get().getId())));
//        }
        return foundData;
    }


//    자료 수정할 때 파일 추가삭제
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void modify(DataDTO dataDTO) {
//        dataDAO.setDataDTO(dataDTO);

//        추가
//        dataDTO.getFiles().forEach(file -> {
//            file.setDataId(dataDTO.getId());
//            fileDAO.save(file);
//        });

//        삭제
//        dataDTO.getFileIdsForDelete().forEach(fileDAO::delete);
//    }


//    자료 삭제
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void remove(Long id) {
//        dataDAO.delete(id);
//        fileDAO.deleteAll(id);
//    }

//    getTotal

    @Override
    public int getTotal() {
        return dataDAO.findCountOfData();
    }

    @Override
    public DataDTO toDTO(DataVO dataVO) {
        return null;
    }
}
