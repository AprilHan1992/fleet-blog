package com.fleet.provider.blog.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.article.Tag;
import com.fleet.common.service.article.TagService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.blog.dao.TagDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag> implements TagService {

    @Resource
    private TagDao tagDao;

    @Override
    public BaseDao<Tag> baseDao() {
        return tagDao;
    }

    @Override
    public Boolean delete(Tag tag) {
        List<Integer> tagIdList = tagDao.tagIdList(tag);
        if (tagIdList != null && tagIdList.size() != 0) {
            tagDao.delete(tag);
            for (Integer tagId : tagIdList) {
                Tag t = new Tag();
                t.setUpperId(tagId);
                delete(t);
            }
        }
        return true;
    }

    @Override
    public List<Integer> tagIdList(Integer tagId) {
        List<Integer> rList = new ArrayList<>();
        rList.add(tagId);

        Tag tag = new Tag();
        tag.setUpperId(tagId);
        List<Integer> tagIdList = tagDao.tagIdList(tag);
        if (tagIdList != null) {
            for (Integer id : tagIdList) {
                rList.addAll(tagIdList(id));
            }
        }
        return rList;
    }

}
