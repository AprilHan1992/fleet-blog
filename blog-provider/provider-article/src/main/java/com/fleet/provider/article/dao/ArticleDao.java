package com.fleet.provider.article.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseDao<Article> {
}
