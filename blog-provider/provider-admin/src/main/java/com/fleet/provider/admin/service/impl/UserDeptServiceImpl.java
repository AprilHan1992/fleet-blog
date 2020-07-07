package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.provider.admin.dao.UserDeptDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class UserDeptServiceImpl extends BaseServiceImpl<UserDept> implements UserDeptService {

    @Resource
    private UserDeptDao userDeptDao;

    @Override
    public BaseDao<UserDept> baseDao() {
        return userDeptDao;
    }

    @Override
    public Dept userDept(Integer id) {
        return userDeptDao.userDept(id);
    }
}
