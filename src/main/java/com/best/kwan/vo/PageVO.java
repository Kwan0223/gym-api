package com.best.kwan.vo;

import com.best.kwan.eums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageVO {

    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    public PageVO(Page<?> page) {
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
}
