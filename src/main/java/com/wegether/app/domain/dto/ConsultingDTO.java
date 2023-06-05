package com.wegether.app.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class ConsultingDTO {
        private Long id;
        private Long memberId;
        private String consultingTitle;
        private String consultingContent;
        private String consultingCategory;
        private String consultingRegisterDate;
        private String memberNickname;
        private List<ConsultingFileDTO> files = new ArrayList<>();
        private List<Long> fileIdsForDelete = new ArrayList<>();
}
