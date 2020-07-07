package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.log.Log;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.log.LogService;
import com.fleet.provider.admin.dao.LogDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

    @Resource
    private LogDao logDao;

    @Override
    public BaseDao<Log> baseDao() {
        return logDao;
    }
}
