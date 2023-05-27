package com.wegether.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class ThumbnailSize {
    private int width;
    private int heigth;
}
