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

/**
 * @author April Han
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public BaseDao<UserRole> baseDao() {
        return userRoleDao;
    }

    @Override
    public List<Integer> idList(UserRole userRole) {
        return userRoleDao.idList(userRole);
    }

    @Override
    public List<Role> roleList(Integer userId) {
        return userRoleDao.roleList(userId);
    }

    @Override
    public List<Menu> menuList(Integer userId) {
        return userRoleDao.menuList(userId);
    }

    @Override
    public List<String> permitList(Integer userId) {
        return userRoleDao.permitList(userId);
    }

    @Override
    public Boolean hasRoles(Integer userId, String[] roles) {
        if (roles != null && roles.length != 0) {
            List<String> roleNameList = userRoleDao.roleNameList(userId);
            if (roleNameList != null && roleNameList.size() != 0) {
                roleNameList.retainAll(Arrays.asList(roles));
                if (roleNameList.size() != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean hasPermits(Integer userId, String[] permits) {
        if (permits != null && permits.length != 0) {
            List<String> permitList = userRoleDao.permitList(userId);
            if (permitList != null && permitList.size() != 0) {
                permitList.retainAll(Arrays.asList(permits));
                if (permitList.size() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
