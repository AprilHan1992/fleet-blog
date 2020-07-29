package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.User;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.common.service.user.UserService;
import com.fleet.provider.admin.dao.UserDao;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author April Han
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;

    @Reference
    private UserRoleService userRoleService;

    @Reference
    private UserDeptService userDeptService;

    @Override
    public BaseDao<User> baseDao() {
        return userDao;
    }

    @Override
    public Boolean insert(User user) {
        if (userDao.insert(user) == 0) {
            return false;
        }
        UserDept userDept = user.getUserDept();
        if (userDept != null) {
            userDept.setUserId(user.getId());
            userDeptService.insert(userDept);
        }
        List<UserRole> userRoleList = user.getUserRoleList();
        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                userRole.setUserId(user.getId());
                userRoleService.insert(userRole);
            }
        }
        return true;
    }

    @Override
    public Boolean update(User user) {
        if (userDao.update(user) == 0) {
            return false;
        }
        UserDept userDept = user.getUserDept();
        if (userDept != null) {
            userDept.setUserId(user.getId());
            userDeptService.update(userDept);
        }
        List<UserRole> userRoleList = user.getUserRoleList();
        if (userRoleList != null) {
            List<Long> roleIdList = userRoleService.roleIdList(user.getId());
            for (UserRole userRole : userRoleList) {
                if (roleIdList != null) {
                    roleIdList.remove(userRole.getRoleId());
                }
                userRole.setUserId(user.getId());
                userRoleService.update(userRole);
            }
            if (roleIdList != null) {
                for (Long roleId : roleIdList) {
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(roleId);
                    userRoleService.delete(userRole);
                }
            }
        }
        return true;
    }
}
