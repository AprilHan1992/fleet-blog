package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.enums.IsDefault;
import com.fleet.common.service.dict.ValueService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.admin.dao.ValueDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Boolean insert(Value value) {
        Value v = new Value();
        v.setDictId(value.getDictId());
        v.setCode(value.getCode());
        v = valueDao.get(v);
        if (v != null) {
            value.setId(v.getId());
        }
        if (value.getIsDefault() != null) {
            if (value.getIsDefault().equals(IsDefault.YES)) {
                v = new Value();
                v.setDictId(value.getDictId());
                v.setIsDefault(IsDefault.YES);
                v = valueDao.get(v);
                if (v != null) {
                    v.setIsDefault(IsDefault.NO);
                    valueDao.update(v);
                }
            }
        } else {
            value.setIsDefault(IsDefault.NO);
        }
        if (value.getId() != null) {
            return valueDao.update(value) != 0;
        } else {
            return valueDao.insert(value) != 0;
        }
    }

    @Override
    public Boolean update(Value value) {
        if (StringUtils.isNotEmpty(value.getCode())) {
            Value v = new Value();
            v.setDictId(value.getDictId());
            v.setCode(value.getCode());
            v = valueDao.get(v);
            if (v != null) {
                value.setId(v.getId());
            }
        }
        if (value.getIsDefault() != null) {
            if (value.getIsDefault().equals(IsDefault.YES)) {
                Value v = new Value();
                v.setDictId(value.getDictId());
                v.setIsDefault(IsDefault.YES);
                v = valueDao.get(v);
                if (v != null) {
                    v.setIsDefault(IsDefault.NO);
                    valueDao.update(v);
                }
            }
        } else {
            value.setIsDefault(IsDefault.NO);
        }
        if (value.getId() != null) {
            return valueDao.update(value) != 0;
        } else {
            return valueDao.insert(value) != 0;
        }
    }

    @Override
    public List<String> codeList(Long dictId) {
        return valueDao.codeList(dictId);
    }
}
