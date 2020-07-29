package com.fleet.provider.blog;

import com.alibaba.fastjson.JSON;
import com.fleet.common.entity.article.Article;
import com.fleet.common.service.article.ArticleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTests {

    @Resource
    private ArticleService articleService;

    @Test
    public void insert() {
        Article article = new Article();
        article.setTitle("测试标题");
        article.setTagId(1L);
        article.setContent("测试内容");
        article.setTags("测试,内容");
        article.setState(1);
        article.setCreatorId(1L);
        article.setCreateTime(new Date());
        articleService.insert(article);
    }

    @Test
    public void delete() {
        Article article = new Article();
        article.setId(1L);
        articleService.delete(article);
    }

    @Test
    public void deletes() {
        Long[] ids = {1L, 2L, 3L};
        articleService.deletes(ids);
    }

    @Test
    public void update() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("修改标题");
        articleService.update(article);
    }

    @Test
    public void get() {
        Article article = new Article();
        article.setId(1L);
        article = articleService.get(article);
        System.out.println(JSON.toJSONString(article));
    }

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        List<Article> list = articleService.list(map);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void listPage() {
        Page page = new Page();
        page.setPageRows(2);
        PageUtil<Article> pageUtil = articleService.listPage(page);
        System.out.println(JSON.toJSONString(pageUtil));
    }
}
