package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.quartz.QuartzJobLogService;
import com.fleet.provider.sys.dao.QuartzJobLogDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class QuartzJobLogServiceImpl extends BaseServiceImpl<QuartzJobLog> implements QuartzJobLogService {

    @Autowired
    private QuartzJobLogDao quartzJobLogDao;

    @Override
    public BaseDao<QuartzJobLog> baseDao() {
        return quartzJobLogDao;
    }

}
