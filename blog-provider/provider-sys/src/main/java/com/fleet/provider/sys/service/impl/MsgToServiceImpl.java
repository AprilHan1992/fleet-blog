package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.MsgTo;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.msg.MsgToService;
import com.fleet.provider.sys.dao.MsgToDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MsgToServiceImpl extends BaseServiceImpl<MsgTo> implements MsgToService {

    @Autowired
    private MsgToDao msgToDao;

    @Override
    public BaseDao<MsgTo> baseDao() {
        return msgToDao;
    }
}
