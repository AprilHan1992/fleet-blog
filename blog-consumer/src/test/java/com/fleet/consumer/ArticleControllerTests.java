package com.fleet.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fleet.common.entity.article.Article;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ArticleControllerTests extends BaseTests {

    @Test
    public void insert() {
        Article article = new Article();
        article.setTitle("测试文章标题");
        article.setTagId(1L);
        article.setTags("测试，文章");
        article.setContent("测试文章内容");
        article.setState(1);
        super.post("/article/insert", JSONObject.toJSONString(article));
    }

    @Test
    public void delete() {
        Article article = new Article();
        article.setId(1L);
        super.post("/article/delete", JSONObject.toJSONString(article));
    }

    @Test
    public void deletes1() {
        super.get("/article/deletes?ids=1&ids=2&ids=3");
        super.post("/article/deletes?ids=1&ids=2&ids=3");
    }

    @Test
    public void deletes2() {
        Map<String, String[]> params = new HashMap<>();
        params.put("ids", new String[]{"1", "2", "3"});
        super.get("/article/deletes", params);
        super.post("/article/deletes", params);
    }

    @Test
    public void update() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("测试文章标题");
        article.setTagId(1L);
        article.setTags("测试，文章");
        article.setContent("测试，文章");
        article.setState(1);
        super.post("/article/update", JSONObject.toJSONString(article));
    }

    @Test
    public void get1() {
        Article article = new Article();
        article.setId(1L);
        super.post("/article/get", JSONObject.toJSONString(article));
    }

    @Test
    public void get2() {
        super.get("/article/get?id=3");
    }

    @Test
    public void list() {
        super.get("/article/list");
    }

    @Test
    public void listPage() {
        Page page = new Page();
        super.post("/article/listPage", JSONObject.toJSONString(page));
    }

    @Test
    public void rcmd() {
        Page page = new Page();
        super.post("/article/rcmd", JSONObject.toJSONString(page));
    }
}
