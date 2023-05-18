package com.wegether.app.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Pagination {
    private int page;
    private int rowCount;
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;

    public Pagination() {
        this(0);
    }

    public Pagination(int total) {
        this.rowCount = 8;
        this.pageCount = 10;
        this.total = total;
        this.endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil(total / (double)rowCount);
        if(realEnd < endPage) {
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
