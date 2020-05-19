package com.fleet.consumer.controller.admin.article;

import com.fleet.common.entity.article.Article;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.article.ArticleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Reference
    private ArticleService articleService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Article article) {
        articleService.insert(article);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("articleId") Integer articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        articleService.delete(article);
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("articleIds") List<Integer> articleIds) {
        for (Integer articleId : articleIds) {
            Article article = new Article();
            article.setArticleId(articleId);
            articleService.delete(article);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Article article) {
        articleService.update(article);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("articleId") Integer articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        return R.ok(articleService.get(article));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(articleService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Article> listPage(@RequestBody(required = false) Page page) {
        return articleService.listPage(page);
    }

    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public PageUtil<Article> recommend(@RequestBody Page page) {
        page.put("articleState", 1);
        page.put("recommend", 1);
        return articleService.listPage(page);
    }

}
