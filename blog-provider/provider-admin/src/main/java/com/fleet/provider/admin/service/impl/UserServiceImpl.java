package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.User;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserService;
import com.fleet.provider.admin.dao.UserDao;
import com.fleet.provider.admin.dao.UserDeptDao;
import com.fleet.provider.admin.dao.UserRoleDao;
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

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private UserDeptDao userDeptDao;

    @Override
    public BaseDao<User> baseDao() {
        return userDao;
    }

    @Override
    public Boolean insert(User user) {
        if (userDao.insert(user) == 0) {
            return false;
        }
        Integer deptId = user.getDeptId();
        if (deptId != null) {
            UserDept userDept = new UserDept();
            userDept.setUserId(user.getId());
            userDept.setDeptId(deptId);
            userDeptDao.insert(userDept);
        }
        List<Integer> roleIdList = user.getRoleIdList();
        if (roleIdList != null) {
            for (Integer roleId : roleIdList) {
                UserRole ur = new UserRole();
                ur.setUserId(user.getId());
                ur.setRoleId(roleId);
                ur = userRoleDao.get(ur);
                if (ur != null) {
                    continue;
                }

                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(roleId);
                userRoleDao.insert(userRole);
            }
        }
        return true;
    }

    @Override
    public Boolean update(User user) {
        if (userDao.update(user) == 0) {
            return false;
        }
        Integer deptId = user.getDeptId();
        if (deptId != null) {
            UserDept ud = new UserDept();
            ud.setUserId(user.getId());
            userDeptDao.delete(ud);

            UserDept userDept = new UserDept();
            userDept.setUserId(user.getId());
            userDept.setDeptId(deptId);
            userDeptDao.insert(userDept);
        }
        List<Integer> roleIdList = user.getRoleIdList();
        if (roleIdList != null) {
            List<Integer> ridList = userRoleDao.roleIdList(user.getId());
            for (Integer roleId : roleIdList) {
                if (ridList != null && ridList.contains(roleId)) {
                    ridList.remove(roleId);
                } else {
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(roleId);
                    userRoleDao.insert(userRole);
                }
            }
            if (ridList != null) {
                for (Integer roleId : ridList) {
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(roleId);
                    userRoleDao.delete(userRole);
                }
            }
        }
        return true;
    }
}
