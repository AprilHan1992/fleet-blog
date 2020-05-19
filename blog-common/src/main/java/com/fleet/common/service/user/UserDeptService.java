package com.fleet.common.service.user;

import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.service.BaseService;

public interface UserDeptService extends BaseService<UserDept> {

    Dept userDept(Integer userId);
}
