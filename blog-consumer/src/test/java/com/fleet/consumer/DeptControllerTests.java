package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DeptControllerTests extends BaseTests {

    @Test
    public void insert() {
        Dept dept = new Dept();
        dept.setName("项目一部一科");
        dept.setUpperId(2L);
        super.post("/dept/insert", JSONObject.toJSONString(dept));
    }

    @Test
    public void delete() {
        Dept dept = new Dept();
        dept.setId(1L);
        super.post("/dept/delete", JSONObject.toJSONString(dept));
    }

    @Test
    public void deletes1() {
        super.get("/dept/deletes?ids=1&ids=2&ids=3");
        super.post("/dept/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/dept/deletes", params);
        super.post("/dept/deletes", params);
    }

    @Test
    public void update() {
        Dept dept = new Dept();
        dept.setId(1L);
        dept.setName("项目部");
        super.post("/dept/update", JSONObject.toJSONString(dept));
    }

    @Test
    public void get1() {
        Dept dept = new Dept();
        dept.setId(1L);
        super.post("/dept/get", JSONObject.toJSONString(dept));
    }

    @Test
    public void get2() {
        super.get("/dept/get?id=3");
    }

    @Test
    public void list() {
        super.get("/dept/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/dept/listPage", JSONObject.toJSONString(page));
    }
}
