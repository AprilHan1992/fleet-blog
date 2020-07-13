package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.entity.dict.Value;
import com.fleet.common.enums.Deleted;
import com.fleet.common.enums.IsDefault;
import com.fleet.common.service.dict.DictService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.admin.dao.DictDao;
import com.fleet.provider.admin.dao.ValueDao;
import org.apache.commons.lang3.StringUtils;
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

    @Resource
    private ValueDao valueDao;

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
                Value v = new Value();
                v.setDictId(dict.getId());
                v.setCode(value.getCode());
                v = valueDao.get(v);
                if (v != null) {
                    value.setId(v.getId());
                }

                if (value.getIsDefault().equals(IsDefault.YES)) {
                    v = new Value();
                    v.setDictId(dict.getId());
                    v.setIsDefault(IsDefault.YES);
                    v = valueDao.get(v);
                    if (v != null) {
                        v.setIsDefault(IsDefault.NO);
                        valueDao.update(v);
                    }
                }

                value.setDictId(dict.getId());
                if (value.getId() != null) {
                    valueDao.update(value);
                } else {
                    valueDao.insert(value);
                }
            }
        }
        return true;
    }

    @Override
    public Boolean delete(Dict dict) {
        List<Integer> idList = dictDao.idList(dict);
        if (idList != null) {
            for (Integer id : idList) {
                Value value = new Value();
                value.setDictId(id);
                valueDao.delete(value);
            }
        }
        return dictDao.delete(dict) != 0;
    }

    @Override
    public Boolean deletes(Integer[] ids) {
        for (Integer id : ids) {
            Value value = new Value();
            value.setDictId(id);
            valueDao.delete(value);
        }
        return dictDao.deletes(ids) != 0;
    }

    @Override
    public Boolean update(Dict dict) {
        if (dictDao.update(dict) == 0) {
            return false;
        }
        List<Value> valueList = dict.getValueList();
        Value v = new Value();
        v.setDictId(dict.getId());
        List<Integer> idList = valueDao.idList(v);
        if (valueList != null) {
            for (Value value : valueList) {
                if (StringUtils.isNotEmpty(value.getCode())) {
                    v = new Value();
                    v.setDictId(dict.getId());
                    v.setCode(value.getCode());
                    v = valueDao.get(v);
                    if (v != null) {
                        value.setId(v.getId());
                    }
                }

                if (value.getIsDefault().equals(IsDefault.YES)) {
                    v = new Value();
                    v.setDictId(dict.getId());
                    v.setIsDefault(IsDefault.YES);
                    v = valueDao.get(v);
                    if (v != null) {
                        v.setIsDefault(IsDefault.NO);
                        valueDao.update(v);
                    }
                }

                value.setDictId(dict.getId());
                if (value.getId() != null) {
                    if (idList != null) {
                        idList.remove(value.getId());
                    }
                    valueDao.update(value);
                } else {
                    valueDao.insert(value);
                }
            }
            if (idList != null && idList.size() != 0) {
                valueDao.deletes(idList.toArray(new Integer[0]));
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
            dict.setValueList(valueDao.list(map));
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
                dict.setValueList(valueDao.list(m));
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
                dict.setValueList(valueDao.list(m));
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }

    @Override
    public String getDefaultValue(String group) {
        return dictDao.getDefaultValue(group);
    }

    @Override
    public String getValue(String group, String code) {
        return dictDao.getValue(group, code);
    }
}
