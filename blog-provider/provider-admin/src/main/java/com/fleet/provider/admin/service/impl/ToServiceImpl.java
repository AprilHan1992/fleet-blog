package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.To;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.msg.ToService;
import com.fleet.provider.admin.dao.ToDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author April Han
 */
@Service
public class ToServiceImpl extends BaseServiceImpl<To> implements ToService {

    @Resource
    private ToDao toDao;

    @Override
    public BaseDao<To> baseDao() {
        return toDao;
    }
}
