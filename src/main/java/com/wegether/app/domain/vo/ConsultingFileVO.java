package com.wegether.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsultingFileVO {
    private Long id;
    private Long consultingId;
}
