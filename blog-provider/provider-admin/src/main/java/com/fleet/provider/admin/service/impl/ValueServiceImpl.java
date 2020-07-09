package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.service.dict.ValueService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.admin.dao.ValueDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author April Han
 */
@Service
public class ValueServiceImpl extends BaseServiceImpl<Value> implements ValueService {

    @Resource
    private ValueDao valueDao;

    @Override
    public BaseDao<Value> baseDao() {
        return valueDao;
    }
}
