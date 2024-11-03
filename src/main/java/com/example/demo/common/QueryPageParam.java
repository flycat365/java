package com.example.demo.common;

import lombok.Data;
import java.util.HashMap;

/**
 * 分页查询参数类
 */
@Data
public class QueryPageParam {
    private int pageSize = 20;
    private int pageNum = 1;
    private HashMap<String, Object> param = new HashMap<>();

    // Getter和Setter
    public HashMap<String, Object> getParam() {
        return param;
    }

    public void setParam(HashMap<String, Object> param) {
        this.param = param;
    }
}