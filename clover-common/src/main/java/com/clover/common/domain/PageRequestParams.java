package com.clover.common.domain;

/**
 * @ClassName: PageRequestParams
 * @Description:
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class PageRequestParams {

    private long startRow;

    private long limit;

    private PageRequestParams(Long startRow, Long limit) {
        this.startRow = startRow;
        this.limit = limit;
    }

    public static PageRequestParams of(Integer pageNo, Integer pageSize) {
        Long startRow = Long.valueOf((pageNo - 1) * pageSize);
        Long limit = Long.valueOf((pageSize));
        return new PageRequestParams(startRow, limit);
    }

    public long getStartRow() {
        return startRow;
    }

    public void setStartRow(long startRow) {
        this.startRow = startRow;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }


}
