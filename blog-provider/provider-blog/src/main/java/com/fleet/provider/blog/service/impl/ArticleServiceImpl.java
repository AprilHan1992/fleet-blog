package com.fleet.provider.blog.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Article;
import com.fleet.common.service.article.ArticleService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.blog.dao.ArticleDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Override
    public BaseDao<Article> baseDao() {
        return articleDao;
    }

}
