package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.User;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserService;
import com.fleet.provider.sys.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public BaseDao<User> baseDao() {
        return userDao;
    }
}
