package com.fleet.provider.article.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Article;
import com.fleet.common.service.article.ArticleService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.article.dao.ArticleDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public BaseDao<Article> baseDao() {
        return articleDao;
    }

}