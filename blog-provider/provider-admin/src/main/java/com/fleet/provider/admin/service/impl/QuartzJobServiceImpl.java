package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.quartz.QuartzJobService;
import com.fleet.provider.admin.dao.QuartzJobDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author April Han
 */
@Service
public class QuartzJobServiceImpl extends BaseServiceImpl<QuartzJob> implements QuartzJobService {

    @Resource
    private QuartzJobDao quartzJobDao;

    @Override
    public BaseDao<QuartzJob> baseDao() {
        return quartzJobDao;
    }
}
