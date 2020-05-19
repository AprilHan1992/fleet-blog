package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.Msg;
import com.fleet.common.entity.msg.MsgTo;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.msg.MsgService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.sys.dao.MsgDao;
import com.fleet.provider.sys.dao.MsgToDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl extends BaseServiceImpl<Msg> implements MsgService {

    @Autowired
    private MsgDao msgDao;

    @Autowired
    private MsgToDao msgToDao;

    @Override
    public BaseDao<Msg> baseDao() {
        return msgDao;
    }

    @Override
    public Boolean insert(Msg msg) {
        if (msgDao.insert(msg) == 0) {
            return false;
        }
        List<MsgTo> msgToList = msg.getMsgToList();
        if (msgToList != null) {
            for (MsgTo msgTo : msgToList) {
                msgTo.setMsgId(msg.getMsgId());
                msgToDao.insert(msgTo);
            }
        }
        return true;
    }

    @Override
    public Boolean update(Msg msg) {
        if (baseDao().update(msg) == 0) {
            return false;
        }
        List<MsgTo> msgToList = msg.getMsgToList();
        if (msgToList != null) {
            MsgTo mt = new MsgTo();
            mt.setMsgId(msg.getMsgId());
            msgToDao.delete(mt);
            for (MsgTo msgTo : msgToList) {
                msgTo.setMsgId(msg.getMsgId());
                msgTo.setDeleted(Deleted.NO);
                msgToDao.update(msgTo);
            }
        }
        return true;
    }

    @Override
    public Msg get(Msg msg) {
        msg = msgDao.get(msg);
        if (msg != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("msgId", msg.getMsgId());
            List<MsgTo> msgToList = msgToDao.list(map);
            msg.setMsgToList(msgToList);
        }
        return msg;
    }

    @Override
    public PageUtil<Msg> userMsgListPage(Page page) {
        PageUtil<Msg> pageUtil = new PageUtil<>();
        List<Msg> list = msgDao.list(page);
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }
}
