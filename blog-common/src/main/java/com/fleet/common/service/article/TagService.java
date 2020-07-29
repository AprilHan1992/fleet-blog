package com.fleet.common.service.article;

import com.fleet.common.entity.article.Tag;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface TagService extends BaseService<Tag> {

    /**
     * 获取所有 tagId 集合（包括）
     */
    List<Long> idList(Long id);
}
