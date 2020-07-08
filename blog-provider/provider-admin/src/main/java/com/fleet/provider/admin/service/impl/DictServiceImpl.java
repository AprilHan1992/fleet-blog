package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.dict.DictService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.admin.dao.DictDao;
import com.fleet.provider.admin.dao.ValueDao;
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
        return valueDao.getDefaultValue(group);
    }

    @Override
    public String getValue(String group, String code) {
        return valueDao.getValue(group, code);
    }
}
