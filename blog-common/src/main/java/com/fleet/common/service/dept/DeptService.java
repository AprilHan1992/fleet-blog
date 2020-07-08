package com.fleet.common.service.dept;

import com.fleet.common.entity.dept.Dept;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface DeptService extends BaseService<Dept> {

    /**
     * 获取所有 id 集合（包括）
     */
    List<Integer> idList(Integer id);

    /**
     * 根据级联名称查询子项id（包括带‘/’名称），查询出多个返回null
     */
    Integer getId(String names);

    /**
     * 查询级联名称
     */
    String getNames(Integer id);

    List<Dept> buildTree(List<Dept> deptList);
}
