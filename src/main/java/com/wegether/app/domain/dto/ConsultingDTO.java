package com.wegether.app.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
}
