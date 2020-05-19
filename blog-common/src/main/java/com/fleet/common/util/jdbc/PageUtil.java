package com.fleet.common.util.jdbc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fleet.common.enums.ResultState;
import com.fleet.common.util.jdbc.entity.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = -1283613600809626906L;

    private Integer code;

    private Map<String, Object> data = new HashMap<>();

    {
        this.code = ResultState.SUCCESS.getCode();
        this.data.put("list", new ArrayList<>());
        this.data.put("page", new Page());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @JsonIgnore
    public List<T> getList() {
        return (List<T>) this.data.get("list");
    }

    public void setList(List<T> list) {
        this.data.put("list", list);
    }

    @JsonIgnore
    public Page getPage() {
        return (Page) this.data.get("page");
    }

    public void setPage(Page page) {
        this.data.put("page", page);
    }
}
