package com.fleet.provider.sys.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.user.UserDept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDeptDao extends BaseDao<UserDept> {

    List<Integer> deptIdList(UserDept userDept);

    Dept userDept(Integer userId);
}
