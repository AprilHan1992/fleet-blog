package com.fleet.provider.article;

import com.fleet.common.entity.article.Article;
import com.fleet.common.service.article.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void insert() {
        Article article = new Article();
        article.setArticleTitle("测试1");
        article.setTagId(1);
        article.setArticleState(1);
        article.setCreatorId(1);
        article.setCreateTime(new Date());
        articleService.insert(article);
    }

}
