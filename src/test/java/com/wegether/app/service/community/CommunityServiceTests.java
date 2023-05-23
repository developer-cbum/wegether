package com.wegether.app.service.community;

import com.wegether.app.dao.FileDAO;
import com.wegether.app.domain.dto.CommunityDTO;
import com.wegether.app.domain.dto.CommunityFileDTO;
import com.wegether.app.domain.dto.CommunityPagination;
import com.wegether.app.domain.dto.CommunityReplyDTO;
import com.wegether.app.domain.type.FileType;
import com.wegether.app.domain.vo.CommunityFileVO;
import com.wegether.app.domain.vo.CommunityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CommunityServiceTests {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private FileDAO fileDAO;

    @Autowired
    private CommunityReplyService communityReplyService;

    @Test
    public void getListTest() {
        CommunityPagination communityPagination = new CommunityPagination();
        communityPagination.progress(5, 10);
        communityService.getList(communityPagination).stream().map(CommunityDTO::toString).forEach(log::info);
    }

    @Test
    public void findByIdTest(){
        communityService.getCommunity(1L).map(CommunityDTO::toString).ifPresent(log::info);
    }

    @Test
    public void writeTest(){

        List<CommunityFileDTO> communityFileDTOS = new ArrayList<>();
        CommunityFileDTO file1 = new CommunityFileDTO();
        CommunityFileDTO file2 = new CommunityFileDTO();
        CommunityFileDTO file3 = new CommunityFileDTO();

        file1.setFileName("새빨간로즈.png");
        file1.setFilePath("2023/05/19");
        file1.setFileSize(1238L);
        file1.setFileUuid(UUID.randomUUID().toString());


        file2.setFileName("새빨간로즈.png");
        file2.setFilePath("2023/05/19");
        file2.setFileSize(1238L);
        file2.setFileUuid(UUID.randomUUID().toString());


        file3.setFileName("새빨간로즈.png");
        file3.setFilePath("2023/05/19");
        file3.setFileSize(1238L);
        file3.setFileUuid(UUID.randomUUID().toString());



        CommunityDTO communityDTO = new CommunityDTO();
        communityDTO.setMemberId(1L);
        communityDTO.setCommunityTitle("인설트");
        communityDTO.setCommunitySubtitle("인설트테스트");
        communityDTO.setCommunityContent("인썰트테스트임당");
        communityFileDTOS.add(file1);
        communityFileDTOS.add(file2);
        communityFileDTOS.add(file3);
        communityDTO.setFiles(communityFileDTOS);
        communityService.write(communityDTO);
    }


//    @Test
//    public void modifyTest() {
//        List<CommunityFileDTO> communityFileDTOS = new ArrayList<>();
//        CommunityFileDTO file1 = new CommunityFileDTO();
//        CommunityFileDTO file2 = new CommunityFileDTO();
//        CommunityFileDTO file3 = new CommunityFileDTO();
//
//        file1.setFileName("새빨간로즈.png");
//        file1.setFilePath("2023/05/19");
//        file1.setFileSize(1238L);
//        file1.setFileUuid(UUID.randomUUID().toString());
//
//        file2.setFileName("새빨간로즈.png");
//        file2.setFilePath("2023/05/19");
//        file2.setFileSize(1238L);
//        file2.setFileUuid(UUID.randomUUID().toString());
//
//        file3.setFileName("새빨간로즈.png");
//        file3.setFilePath("2023/05/19");
//        file3.setFileSize(1238L);
//        file3.setFileUuid(UUID.randomUUID().toString());
//
//        communityFileDTOS.add(file1);
//        communityFileDTOS.add(file2);
//        communityFileDTOS.add(file3);
//
//        Optional<CommunityDTO> foundCommunity = communityService.getCommunity(1L);
//        foundCommunity.ifPresent(communityVO -> communityVO.setCommunityContent("점핑예점핑"));
//        foundCommunity.ifPresent(communityDTO -> communityDTO.setFiles(communityFileDTOS));
//        CommunityDTO communityDTO = foundCommunity.orElseThrow();
//        communityService.modify(communityDTO);
//        communityService.getCommunity(1L);

//        CommunityDTO communityDTO = communityService.getCommunity(1L).orElseThrow();
//        List<Long> tests = new ArrayList<>();

//        CommunityDTO communityDTO = communityService.getCommunity(5L).get();
//
//        List<Long> test = communityService.getCommunity(5L).get().getFileIdsForDelete();
//        test.add(10L);
//        test.add(11L);
//
//        communityDTO.setFileIdsForDelete(test);
//
//        communityService.modify(communityDTO);
//
//
//    }


    @Test
    public void removeTest() {
        communityService.remove(5L);
    }

    @Test
    public void replyInsert(){
        CommunityReplyDTO communityReplyDTO = new CommunityReplyDTO();
        communityReplyDTO.setReplyContent("dd");
        communityReplyService.register(communityReplyDTO);
    }

    @Test
    public void depthInsert(){
        CommunityReplyDTO communityReplyDTO = new CommunityReplyDTO();
        communityReplyDTO.setReplyContent("ddd");
        communityReplyDTO.setReplyGroup(5L);
        communityReplyService.registerDepth(communityReplyDTO);
    }

}
