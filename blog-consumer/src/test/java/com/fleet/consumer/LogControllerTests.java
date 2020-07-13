package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.log.Log;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LogControllerTests extends BaseTests {

    @Test
    public void delete() {
        Log log = new Log();
        log.setId(1L);
        super.post("/log/delete", JSONObject.toJSONString(log));
    }

    @Test
    public void deletes1() {
        super.get("/log/deletes?ids=1&ids=2&ids=3");
        super.post("/log/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/log/deletes", params);
        super.post("/log/deletes", params);
    }

    @Test
    public void get1() {
        Log log = new Log();
        log.setId(1L);
        super.post("/log/get", JSONObject.toJSONString(log));
    }

    @Test
    public void get2() {
        super.get("/log/get?id=3");
    }

    @Test
    public void list() {
        super.get("/log/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/log/listPage", JSONObject.toJSONString(page));
    }
}
