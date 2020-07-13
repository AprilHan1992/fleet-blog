package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.enums.Enabled;
import com.fleet.common.enums.Opened;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MenuControllerTests extends BaseTests {

    @Test
    public void insert() {
        Menu menu = new Menu();
        menu.setType(1);
        menu.setName("工具");
        menu.setOpened(Opened.YES);
        menu.setEnabled(Enabled.YES);
        menu.setUpperId(0);
        super.post("/menu/insert", JSONObject.toJSONString(menu));
    }

    @Test
    public void delete() {
        Menu menu = new Menu();
        menu.setId(1);
        super.post("/menu/delete", JSONObject.toJSONString(menu));
    }

    @Test
    public void deletes1() {
        super.get("/menu/deletes?ids=1&ids=2&ids=3");
        super.post("/menu/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/menu/deletes", params);
        super.post("/menu/deletes", params);
    }

    @Test
    public void update() {
        Menu menu = new Menu();
        menu.setId(1);
        menu.setType(1);
        menu.setName("工具");
        menu.setOpened(Opened.YES);
        menu.setEnabled(Enabled.YES);
        menu.setUpperId(0);
        super.post("/menu/update", JSONObject.toJSONString(menu));
    }

    @Test
    public void get1() {
        Menu menu = new Menu();
        menu.setId(1);
        super.post("/menu/get", JSONObject.toJSONString(menu));
    }

    @Test
    public void get2() {
        super.get("/menu/get?id=3");
    }

    @Test
    public void list() {
        super.get("/menu/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/menu/listPage", JSONObject.toJSONString(page));
    }
}
