package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.provider.sys.dao.UserDeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserDeptServiceImpl extends BaseServiceImpl<UserDept> implements UserDeptService {

    @Autowired
    private UserDeptDao userDeptDao;

    @Override
    public BaseDao<UserDept> baseDao() {
        return userDeptDao;
    }

    @Override
    public Dept userDept(Integer userId) {
        return userDeptDao.userDept(userId);
    }
}
