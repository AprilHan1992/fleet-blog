package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.To;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.msg.ToService;
import com.fleet.provider.admin.dao.ToDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author April Han
 */
@Service
public class ToServiceImpl extends BaseServiceImpl<To> implements ToService {

    @Resource
    private ToDao toDao;

    @Override
    public BaseDao<To> baseDao() {
        return toDao;
    }

    @Override
    public Boolean insert(To to) {
        To t = new To();
        t.setMsgId(to.getMsgId());
        t.setToId(to.getToId());
        t = toDao.get(t);
        if (t != null) {
            to.setId(t.getId());
        }
        if (to.getId() != null) {
            return toDao.update(to) != 0;
        } else {
            return toDao.insert(to) != 0;
        }
    }

    @Override
    public Boolean update(To to) {
        if (to.getToId() != null) {
            To t = new To();
            t.setMsgId(to.getMsgId());
            t.setToId(to.getToId());
            t = toDao.get(t);
            if (t != null) {
                to.setId(t.getId());
            }
        }
        if (to.getId() != null) {
            return toDao.update(to) != 0;
        } else {
            return toDao.insert(to) != 0;
        }
    }

    @Override
    public List<Integer> toIdList(Integer msgId) {
        return toDao.toIdList(msgId);
    }
}
