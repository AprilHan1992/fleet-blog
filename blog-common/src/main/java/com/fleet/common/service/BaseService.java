package com.fleet.common.service;

import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
public interface BaseService<T> {

    /**
     * 新增
     *
     * @param t
     * @return
     */
    Boolean insert(T t);

    /**
     * 删除
     *
     * @param t
     * @return
     */
    Boolean delete(T t);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Boolean delete(Integer[] ids);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    Boolean update(T t);

    /**
     * 查询
     *
     * @param t
     * @return
     */
    T get(T t);

    /**
     * 列表查询
     *
     * @param map
     * @return
     */
    List<T> list(Map<String, Object> map);

    /**
     * 列表查询（分页）
     *
     * @param page
     * @return
     */
    PageUtil<T> listPage(Page page);
}
