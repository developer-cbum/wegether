package com.wegether.app.mapper;

import com.wegether.app.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {

    // 공지사항 목록
    public List<NoticeVO> noticeSelectAll();

    // 공지사항 등록
    public void noticeInsert(NoticeVO noticeVO);

    // 공지사항 상세
    public Optional<NoticeVO> noticeSelect(Long id);

    // 공지사항 수정
    public void noticeUpdate(NoticeVO noticeVO);

    // 공지사항 삭제
    public void noticeDelete(Long id);

}
