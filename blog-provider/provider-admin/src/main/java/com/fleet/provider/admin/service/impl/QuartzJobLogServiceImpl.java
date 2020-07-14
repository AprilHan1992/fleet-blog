package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.quartz.QuartzJobLogService;
import com.fleet.provider.admin.dao.QuartzJobLogDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author April Han
 */
@Component
@Service(async = true)
public class QuartzJobLogServiceImpl extends BaseServiceImpl<QuartzJobLog> implements QuartzJobLogService {

    @Resource
    private QuartzJobLogDao quartzJobLogDao;

    @Override
    public BaseDao<QuartzJobLog> baseDao() {
        return quartzJobLogDao;
    }

    @Async
    @Override
    public Boolean insert(QuartzJobLog quartzJobLog) {
        return quartzJobLogDao.insert(quartzJobLog) != 0;
    }
}
