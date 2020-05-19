package com.fleet.provider.article.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagDao extends BaseDao<Tag> {

    List<Integer> tagIdList(Tag tag);
}
