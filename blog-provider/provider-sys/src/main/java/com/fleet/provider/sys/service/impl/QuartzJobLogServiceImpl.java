package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.quartz.QuartzJobLogService;
import com.fleet.provider.sys.dao.QuartzJobLogDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service
public class QuartzJobLogServiceImpl extends BaseServiceImpl<QuartzJobLog> implements QuartzJobLogService {

    @Resource
    private QuartzJobLogDao quartzJobLogDao;

    @Override
    public BaseDao<QuartzJobLog> baseDao() {
        return quartzJobLogDao;
    }

}
