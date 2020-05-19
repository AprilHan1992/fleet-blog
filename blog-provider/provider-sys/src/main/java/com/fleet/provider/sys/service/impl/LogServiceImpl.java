package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.log.Log;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.log.LogService;
import com.fleet.provider.sys.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public BaseDao<Log> baseDao() {
        return logDao;
    }
}
