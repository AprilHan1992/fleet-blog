package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.Msg;
import com.fleet.common.entity.msg.To;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.msg.MsgService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.admin.dao.MsgDao;
import com.fleet.provider.admin.dao.ToDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@Service
public class MsgServiceImpl extends BaseServiceImpl<Msg> implements MsgService {

    @Resource
    private MsgDao msgDao;

    @Resource
    private ToDao toDao;

    @Override
    public BaseDao<Msg> baseDao() {
        return msgDao;
    }

    @Override
    public Boolean insert(Msg msg) {
        if (msgDao.insert(msg) == 0) {
            return false;
        }
        List<To> toList = msg.getToList();
        if (toList != null) {
            for (To to : toList) {
                to.setMsgId(msg.getId());
                toDao.insert(to);
            }
        }
        return true;
    }

    @Override
    public Boolean update(Msg msg) {
        if (msgDao.update(msg) == 0) {
            return false;
        }
        List<To> toList = msg.getToList();
        if (toList != null) {
            To to = new To();
            to.setMsgId(msg.getId());
            List<Integer> idList = toDao.idList(to);
            for (To t : toList) {
                if (t.getId() != null) {
                    if (idList != null) {
                        idList.remove(t.getId());
                    }
                    t.setMsgId(msg.getId());
                    toDao.update(t);
                } else {
                    t.setMsgId(msg.getId());
                    toDao.insert(t);
                }
            }
            if (idList != null && idList.size() != 0) {
                toDao.deletes(idList.toArray(new Integer[0]));
            }
        }
        return true;
    }

    @Override
    public Msg get(Msg msg) {
        msg = msgDao.get(msg);
        if (msg != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("deleted", Deleted.NO);
            map.put("msgId", msg.getId());
            msg.setToList(toDao.list(map));
        }
        return msg;
    }

    @Override
    public PageUtil<Msg> toListPage(Page page) {
        PageUtil<Msg> pageUtil = new PageUtil<>();
        List<Msg> list = msgDao.toList(page);
        if (list != null) {
            for (Msg msg : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("deleted", Deleted.NO);
                map.put("msgId", msg.getId());
                msg.setToList(toDao.list(map));
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }
}
