package com.fleet.common.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.service.BaseService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> baseDao();

    @Override
    public Boolean insert(T t) {
        return baseDao().insert(t) != 0;
    }

    @Override
    public Boolean delete(T t) {
        return baseDao().delete(t) != 0;
    }

    @Override
    public Boolean deletes(Long[] ids) {
        return baseDao().deletes(ids) != 0;
    }

    @Override
    public Boolean update(T t) {
        return baseDao().update(t) != 0;
    }

    @Override
    public T get(T t) {
        return baseDao().get(t);
    }

    @Override
    public List<T> list(Map<String, Object> map) {
        return baseDao().list(map);
    }

    @Override
    public PageUtil<T> listPage(Page page) {
        PageUtil<T> pageUtil = new PageUtil<>();
        List<T> list = baseDao().list(page);
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }
}
