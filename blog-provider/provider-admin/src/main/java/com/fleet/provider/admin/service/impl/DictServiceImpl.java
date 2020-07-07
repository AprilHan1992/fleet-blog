package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Dict;
import com.fleet.common.entity.dict.DictValue;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.dict.DictService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.provider.admin.dao.DictDao;
import com.fleet.provider.admin.dao.DictValueDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    @Resource
    private DictDao dictDao;

    @Resource
    private DictValueDao dictValueDao;

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
            map.put("dictId", dict.getDictId());
            List<DictValue> dictValueList = dictValueDao.list(map);
            dict.setDictValueList(dictValueList);
        }
        return dict;
    }

    @Override
    public List<Dict> list(Map<String, Object> map) {
        List<Dict> dictList = dictDao.list(map);
        if (dictList != null) {
            for (Dict dict : dictList) {
                Map<String, Object> m = new HashMap<>();
                m.put("deleted", Deleted.NO);
                m.put("dictId", dict.getDictId());
                List<DictValue> dictValueList = dictValueDao.list(m);
                dict.setDictValueList(dictValueList);
            }
        }
        return dictList;
    }

    @Override
    public PageUtil<Dict> listPage(Page page) {
        PageUtil<Dict> pageUtil = new PageUtil<>();
        HashMap<String, Object> map = (HashMap<String, Object>) page;
        List<Dict> list = dictDao.list(map);
        if (list != null) {
            for (Dict dict : list) {
                Map<String, Object> m = new HashMap<>();
                m.put("deleted", Deleted.NO);
                m.put("dictId", dict.getDictId());
                List<DictValue> dictValueList = dictValueDao.list(m);
                dict.setDictValueList(dictValueList);
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }

    @Override
    public String getDefaultValue(String dictGroup) {
        return dictValueDao.getDefaultValue(dictGroup);
    }

    @Override
    public String getValue(String dictGroup, String dictValueCode) {
        return dictValueDao.getValue(dictGroup, dictValueCode);
    }

}
