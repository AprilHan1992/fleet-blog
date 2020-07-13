package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.article.Tag;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TagControllerTests extends BaseTests {

    @Test
    public void insert() {
        Tag tag = new Tag();
        tag.setType(2);
        tag.setTag("测试");
        tag.setSort(0);
        tag.setUpperId(0);
        super.post("/tag/insert", JSONObject.toJSONString(tag));
    }

    @Test
    public void delete() {
        Tag tag = new Tag();
        tag.setId(1);
        super.post("/tag/delete", JSONObject.toJSONString(tag));
    }

    @Test
    public void deletes1() {
        super.get("/tag/deletes?ids=1&ids=2&ids=3");
        super.post("/tag/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/tag/deletes", params);
        super.post("/tag/deletes", params);
    }

    @Test
    public void update() {
        Tag tag = new Tag();
        tag.setId(1);
        tag.setType(2);
        tag.setTag("测试");
        super.post("/tag/update", JSONObject.toJSONString(tag));
    }

    @Test
    public void get1() {
        Tag tag = new Tag();
        tag.setId(1);
        super.post("/tag/get", JSONObject.toJSONString(tag));
    }

    @Test
    public void get2() {
        super.get("/tag/get?id=3");
    }

    @Test
    public void list() {
        super.get("/tag/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/tag/listPage", JSONObject.toJSONString(page));
    }
}
