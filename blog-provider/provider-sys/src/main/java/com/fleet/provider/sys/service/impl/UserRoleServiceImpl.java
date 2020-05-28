package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.provider.sys.dao.UserRoleDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public BaseDao<UserRole> baseDao() {
        return userRoleDao;
    }

    @Override
    public List<Role> userRoleList(Integer userId) {
        return userRoleDao.userRoleList(userId);
    }

    @Override
    public List<String> userRoles(Integer userId) {
        return userRoleDao.userRoles(userId);
    }

    @Override
    public List<Menu> userMenuList(Integer userId) {
        return userRoleDao.userMenuList(userId);
    }

    @Override
    public List<String> userPermits(Integer userId) {
        return userRoleDao.userPermits(userId);
    }

    @Override
    public Boolean hasRoles(Integer userId, String[] roles) {
        if (roles != null && roles.length != 0) {
            List<String> userRoles = userRoles(userId);
            if (userRoles != null && userRoles.size() != 0) {
                userRoles.retainAll(Arrays.asList(roles));
                if (userRoles.size() != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean hasPermits(Integer userId, String[] permits) {
        if (permits != null && permits.length != 0) {
            List<String> userPermits = userPermits(userId);
            if (userPermits != null && userPermits.size() != 0) {
                userPermits.retainAll(Arrays.asList(permits));
                if (userPermits.size() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
