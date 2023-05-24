package com.wegether.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class NoticeAdminDTO {
    private Long id;
    private String noticeTitle;
    private String noticeContent;
    private String noticeRegisterDate;
    private String noticeUpdateDate;
    private List<NoticeFileAdminDTO> files = new ArrayList<>();
}
