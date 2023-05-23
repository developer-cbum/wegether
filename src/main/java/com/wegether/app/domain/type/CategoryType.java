package com.wegether.app.domain.type;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CategoryType {
    private String type;
    private String order;
}