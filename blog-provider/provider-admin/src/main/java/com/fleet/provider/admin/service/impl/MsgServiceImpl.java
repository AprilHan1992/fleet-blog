package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.Msg;
import com.fleet.common.entity.msg.To;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.msg.MsgService;
import com.fleet.common.service.msg.ToService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.admin.dao.MsgDao;
import org.apache.dubbo.config.annotation.Reference;
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

    @Reference
    private ToService toService;

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
                toService.insert(to);
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
            List<Integer> toIdList = toService.toIdList(msg.getId());
            for (To to : toList) {
                if (toIdList != null) {
                    toIdList.remove(to.getToId());
                }
                to.setMsgId(msg.getId());
                toService.update(to);
            }
            if (toIdList != null) {
                for (Integer toId : toIdList) {
                    To to = new To();
                    to.setMsgId(msg.getId());
                    to.setToId(toId);
                    toService.delete(to);
                }
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
            msg.setToList(toService.list(map));
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
                msg.setToList(toService.list(map));
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }
}
