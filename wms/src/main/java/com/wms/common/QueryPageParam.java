package com.wms.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class QueryPageParam {
    // default
    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM = 1;

    private int pageSize = PAGE_SIZE;
    private int pageNum = PAGE_NUM;

    private HashMap param;

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public HashMap getParam() {
        return param;
    }
}
