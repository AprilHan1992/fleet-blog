package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.role.RoleMenu;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RoleMenuControllerTests extends BaseTests {

    @Test
    public void insert() {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(1L);
        roleMenu.setMenuId(1L);
        super.post("/role/menu/insert", JSONObject.toJSONString(roleMenu));
    }

    @Test
    public void delete() {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(1L);
        super.post("/role/menu/delete", JSONObject.toJSONString(roleMenu));
    }

    @Test
    public void deletes1() {
        super.get("/role/menu/deletes?ids=1&ids=2&ids=3");
        super.post("/role/menu/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/role/menu/deletes", params);
        super.post("/role/menu/deletes", params);
    }

    @Test
    public void update() {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(1L);
        roleMenu.setRoleId(1L);
        roleMenu.setMenuId(1L);
        super.post("/role/menu/update", JSONObject.toJSONString(roleMenu));
    }

    @Test
    public void get1() {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(1L);
        super.post("/role/menu/get", JSONObject.toJSONString(roleMenu));
    }

    @Test
    public void get2() {
        super.get("/role/menu/get?id=3");
    }

    @Test
    public void list() {
        super.get("/role/menu/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/role/menu/listPage", JSONObject.toJSONString(page));
    }
}
