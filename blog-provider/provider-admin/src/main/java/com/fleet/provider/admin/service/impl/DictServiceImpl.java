package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.dict.DictService;
import com.fleet.common.service.dict.ValueService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.admin.dao.DictDao;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    @Resource
    private DictDao dictDao;

    @Reference
    private ValueService valueService;

    @Override
    public BaseDao<Dict> baseDao() {
        return dictDao;
    }

    @Override
    public Boolean insert(Dict dict) {
        if (dictDao.insert(dict) == 0) {
            return false;
        }
        List<Value> valueList = dict.getValueList();
        if (valueList != null) {
            for (Value value : valueList) {
                value.setDictId(dict.getId());
                valueService.insert(value);
            }
        }
        return true;
    }

    @Override
    public Boolean delete(Dict dict) {
        List<Long> idList = dictDao.idList(dict);
        if (idList != null) {
            for (Long id : idList) {
                Value value = new Value();
                value.setDictId(id);
                valueService.delete(value);
            }
        }
        return dictDao.delete(dict) != 0;
    }

    @Override
    public Boolean deletes(Long[] ids) {
        for (Long id : ids) {
            Value value = new Value();
            value.setDictId(id);
            valueService.delete(value);
        }
        return dictDao.deletes(ids) != 0;
    }

    @Override
    public Boolean update(Dict dict) {
        if (dictDao.update(dict) == 0) {
            return false;
        }
        List<Value> valueList = dict.getValueList();
        if (valueList != null) {
            List<String> codeList = valueService.codeList(dict.getId());
            for (Value value : valueList) {
                if (codeList != null) {
                    codeList.remove(value.getCode());
                }
                value.setDictId(dict.getId());
                valueService.update(value);
            }
            if (codeList != null) {
                for (String code : codeList) {
                    Value value = new Value();
                    value.setDictId(dict.getId());
                    value.setCode(code);
                    valueService.delete(value);
                }
            }
        }
        return true;
    }

    @Override
    public Dict get(Dict dict) {
        dict = dictDao.get(dict);
        if (dict != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("deleted", Deleted.NO);
            map.put("dictId", dict.getId());
            dict.setValueList(valueService.list(map));
        }
        return dict;
    }

    @Override
    public List<Dict> list(Map<String, Object> map) {
        List<Dict> list = dictDao.list(map);
        if (list != null) {
            for (Dict dict : list) {
                Map<String, Object> m = new HashMap<>();
                m.put("deleted", Deleted.NO);
                m.put("dictId", dict.getId());
                dict.setValueList(valueService.list(m));
            }
        }
        return list;
    }

    @Override
    public PageUtil<Dict> listPage(Page page) {
        PageUtil<Dict> pageUtil = new PageUtil<>();
        List<Dict> list = dictDao.list(page);
        if (list != null) {
            for (Dict dict : list) {
                Map<String, Object> m = new HashMap<>();
                m.put("deleted", Deleted.NO);
                m.put("dictId", dict.getId());
                dict.setValueList(valueService.list(m));
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }

    @Override
    public String getDefaultValue(String group) {
        String defaultValue = dictDao.getDefaultValue(group);
        if (defaultValue == null) {
            List<String> valueList = dictDao.getValueList(group);
            if (valueList != null && valueList.size() == 1) {
                defaultValue = valueList.get(0);
            }
        }
        return defaultValue;
    }

    @Override
    public String getValue(String group, String code) {
        return dictDao.getValue(group, code);
    }
}
