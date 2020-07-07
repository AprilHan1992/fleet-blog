package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.provider.admin.dao.UserRoleDao;
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
    public List<Role> userRoleList(Integer id) {
        return userRoleDao.userRoleList(id);
    }

    @Override
    public List<String> userRoles(Integer id) {
        return userRoleDao.userRoles(id);
    }

    @Override
    public List<Menu> userMenuList(Integer id) {
        return userRoleDao.userMenuList(id);
    }

    @Override
    public List<String> userPermits(Integer id) {
        return userRoleDao.userPermits(id);
    }

    @Override
    public Boolean hasRoles(Integer id, String[] roles) {
        if (roles != null && roles.length != 0) {
            List<String> userRoles = userRoles(id);
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
    public Boolean hasPermits(Integer id, String[] permits) {
        if (permits != null && permits.length != 0) {
            List<String> userPermits = userPermits(id);
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
