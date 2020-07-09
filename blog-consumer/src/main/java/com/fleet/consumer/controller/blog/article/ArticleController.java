package com.fleet.consumer.controller.blog.article;

import com.fleet.common.entity.article.Article;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.article.ArticleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("OpenArticleController")
@RequestMapping("/open/article")
public class ArticleController {

    @Reference
    private ArticleService articleService;

    @GetMapping("/get")
    public R get(@RequestParam("articleId") Integer articleId) {
        Article article = new Article();
        article.setId(articleId);
        return R.ok(articleService.get(article));
    }

    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(articleService.list(map));
    }

    @PostMapping("/listPage")
    public PageUtil<Article> listPage(@RequestBody(required = false) Page page) {
        return articleService.listPage(page);
    }

    @PostMapping("/rcmd")
    public PageUtil<Article> rcmd(@RequestBody Page page) {
        page.put("state", 1);
        page.put("rcmd", 1);
        return articleService.listPage(page);
    }
}
