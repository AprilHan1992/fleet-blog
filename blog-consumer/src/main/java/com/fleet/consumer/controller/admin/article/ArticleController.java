package com.fleet.consumer.controller.admin.article;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.article.Article;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.article.ArticleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 文章管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController<Article> {

    @Reference
    private ArticleService articleService;

    @Override
    public BaseService<Article> baseService() {
        return articleService;
    }

    @Override
    @PostMapping("/insert")
    public R insert(@RequestBody Article article) {
        article.setCreatorId(getUserId());
        article.setCreateTime(new Date());
        if (!articleService.insert(article)) {
            return R.error();
        }
        return R.ok();
    }

    @Override
    @PostMapping("/update")
    public R update(@RequestBody Article article) {
        article.setEditorId(getUserId());
        article.setEditTime(new Date());
        if (!articleService.update(article)) {
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        Article article = new Article();
        article.setId(id);
        return get(article);
    }

    @PostMapping("/rcmd")
    public PageUtil<Article> rcmd(@RequestBody Page page) {
        page.put("state", 1);
        page.put("rcmd", 1);
        return articleService.listPage(page);
    }
}
