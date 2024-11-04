package com.example.demo.common;

import lombok.Data;
import java.util.HashMap;

/**
 * 分页查询参数类
 */
public class QueryPageParam {
    private int pageSize;
    private int pageNum;
    private HashMap<String, Object> param;

    // Getters and Setters
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public HashMap<String, Object> getParam() {
        return param;
    }

    public void setParam(HashMap<String, Object> param) {
        this.param = param;
    }
}