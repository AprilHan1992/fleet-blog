package com.fleet.common.dao;

import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
public interface BaseDao<T> {

    /**
     * 新增
     *
     * @param t
     * @return
     */
    Integer insert(T t);

    /**
     * 删除
     *
     * @param t
     * @return
     */
    Integer delete(T t);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Integer deletes(Long[] ids);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    Integer update(T t);

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
}
