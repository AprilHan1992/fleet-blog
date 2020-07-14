package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.role.Role;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RoleControllerTests extends BaseTests {

    @Test
    public void insert() {
        Role role = new Role();
        role.setName("超级管理员");
        role.setUpperId(0);
        super.post("/role/insert", JSONObject.toJSONString(role));
    }

    @Test
    public void delete() {
        Role role = new Role();
        role.setId(1);
        super.post("/role/delete", JSONObject.toJSONString(role));
    }

    @Test
    public void deletes1() {
        super.get("/role/deletes?ids=1&ids=2&ids=3");
        super.post("/role/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/role/deletes", params);
        super.post("/role/deletes", params);
    }

    @Test
    public void update() {
        Role role = new Role();
        role.setId(1);
        role.setName("管理员");
        super.post("/role/update", JSONObject.toJSONString(role));
    }

    @Test
    public void get1() {
        Role role = new Role();
        role.setId(1);
        super.post("/role/get", JSONObject.toJSONString(role));
    }

    @Test
    public void get2() {
        super.get("/role/get?id=3");
    }

    @Test
    public void list() {
        super.get("/role/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/role/listPage", JSONObject.toJSONString(page));
    }
}
