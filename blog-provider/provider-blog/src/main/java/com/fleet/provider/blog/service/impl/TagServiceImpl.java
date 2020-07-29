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

/**
 * @author April Han
 */
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
        List<Long> idList = tagDao.idList(tag);
        if (idList != null && idList.size() != 0) {
            tagDao.delete(tag);
            for (Long id : idList) {
                Tag t = new Tag();
                t.setUpperId(id);
                delete(t);
            }
        }
        return true;
    }

    @Override
    public Boolean deletes(Long[] ids) {
        for (Long id : ids) {
            Tag tag = new Tag();
            tag.setId(id);
            delete(tag);
        }
        return true;
    }

    @Override
    public List<Long> idList(Long id) {
        List<Long> rList = new ArrayList<>();
        rList.add(id);

        Tag tag = new Tag();
        tag.setUpperId(id);
        List<Long> idList = tagDao.idList(tag);
        if (idList != null) {
            for (Long i : idList) {
                rList.addAll(idList(i));
            }
        }
        return rList;
    }
}
