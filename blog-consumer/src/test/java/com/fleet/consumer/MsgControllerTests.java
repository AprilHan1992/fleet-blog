package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.msg.Msg;
import com.fleet.common.entity.msg.To;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MsgControllerTests extends BaseTests {

    @Test
    public void insert() {
        Msg msg = new Msg();
        msg.setTitle("消息标题");
        msg.setExcerpt("消息摘要");
        msg.setUrl("http://www.fleetsoft.com");
        msg.setState(1);

        List<To> toList = new ArrayList<>();
        To to = new To();
        to.setToId(1);
        toList.add(to);
        msg.setToList(toList);
        super.post("/msg/insert", JSONObject.toJSONString(msg));
    }

    @Test
    public void delete() {
        Msg msg = new Msg();
        msg.setId(1L);
        super.post("/msg/delete", JSONObject.toJSONString(msg));
    }

    @Test
    public void deletes1() {
        super.get("/msg/deletes?ids=1&ids=2&ids=3");
        super.post("/msg/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/msg/deletes", params);
        super.post("/msg/deletes", params);
    }

    @Test
    public void update() {
        Msg msg = new Msg();
        msg.setId(1L);
        msg.setTitle("消息标题");
        msg.setExcerpt("消息摘要");
        msg.setUrl("http://www.fleetsoft.com");
        msg.setState(1);

        List<To> toList = new ArrayList<>();
        To to = new To();
        to.setToId(1);
        toList.add(to);
        msg.setToList(toList);
        super.post("/msg/update", JSONObject.toJSONString(msg));
    }

    @Test
    public void get1() {
        Msg msg = new Msg();
        msg.setId(1L);
        super.post("/msg/get", JSONObject.toJSONString(msg));
    }

    @Test
    public void get2() {
        super.get("/msg/get?id=3");
    }

    @Test
    public void list() {
        super.get("/msg/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/msg/listPage", JSONObject.toJSONString(page));
    }

    @Test
    public void toListPage() {
        Page page = new Page();
        super.post("/msg/toListPage", JSONObject.toJSONString(page));
    }
}
