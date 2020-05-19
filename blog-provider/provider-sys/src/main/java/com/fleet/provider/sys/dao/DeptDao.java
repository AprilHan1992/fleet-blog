package com.fleet.provider.sys.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao extends BaseDao<Dept> {

    List<Integer> deptIdList(Dept dept);

}
