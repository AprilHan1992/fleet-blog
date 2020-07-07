package com.fleet.provider.blog.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author April Han
 */
@Mapper
public interface ArticleDao extends BaseDao<Article> {
}
