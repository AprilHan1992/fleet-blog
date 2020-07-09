package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.User;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserService;
import com.fleet.provider.admin.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author April Han
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public BaseDao<User> baseDao() {
        return userDao;
    }
}
