package com.wegether.app.mapper.consultings;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;
import com.wegether.app.mapper.ConsultingReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ConsultingReplyMapperTests {


    @Autowired
    private ConsultingReplyMapper consultingReplyMapper;

    //댓글 등록
    @Test
    public void insertReplyTest(){
        ConsultReplyDTO consultReplyDTO = new ConsultReplyDTO();
        consultReplyDTO.setReplyContent("댓글이용");
        consultingReplyMapper.insertReply(consultReplyDTO);
    }


    // 대댓글 등록
    @Test
    public void insertReplyAgainTest(){
        ConsultReplyDTO consultReplyDTO = new ConsultReplyDTO();
        consultReplyDTO.setReplyContent("대댓글이용");
        // 그 댓글의 아이디
        consultReplyDTO.setReplyGroup(1L);

        consultingReplyMapper.insertReplyAgain(consultReplyDTO);
    }


    @Test
    //일반 댓글 페이징을 가져오기
    public void selectAllTest(){
        LecturePagination lecturePagination = new LecturePagination();
        lecturePagination.progress(5,5);
        consultingReplyMapper.selectAll(lecturePagination);
    }


}
