package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.DictValue;
import com.fleet.common.service.dict.DictValueService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.sys.dao.DictValueDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service
public class DictValueServiceImpl extends BaseServiceImpl<DictValue> implements DictValueService {

    @Resource
    private DictValueDao dictValueDao;

    @Override
    public BaseDao<DictValue> baseDao() {
        return dictValueDao;
    }

}
