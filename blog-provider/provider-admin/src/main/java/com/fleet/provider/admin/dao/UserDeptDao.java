package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.user.UserDept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface UserDeptDao extends BaseDao<UserDept> {

    List<Integer> idList(UserDept userDept);

    Dept dept(Integer userId);
}
