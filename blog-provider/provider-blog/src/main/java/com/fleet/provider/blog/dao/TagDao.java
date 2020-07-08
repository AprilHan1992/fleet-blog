package com.fleet.provider.blog.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author April Han
 */
@Mapper
public interface TagDao extends BaseDao<Tag> {

    List<Integer> idList(Tag tag);
}
