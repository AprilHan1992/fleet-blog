package com.fleet.common.service.dept;

import com.fleet.common.entity.dept.Dept;
import com.fleet.common.service.BaseService;

import java.util.List;

/**
 * @author April Han
 */
public interface DeptService extends BaseService<Dept> {

    /**
     * 获取所有 deptId 集合（包括）
     */
    List<Long> idList(Long id);

    /**
     * 根据级联名称查询子项id（包括带‘/’名称），查询出多个返回null
     */
    Long getId(String names);

    /**
     * 查询级联名称
     */
    String getNames(Long id);

    List<Dept> buildTree(List<Dept> deptList);
}
