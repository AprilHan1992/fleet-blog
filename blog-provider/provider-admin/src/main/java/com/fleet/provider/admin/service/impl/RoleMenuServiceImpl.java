package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.RoleMenu;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.role.RoleMenuService;
import com.fleet.provider.admin.dao.RoleMenuDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author April Han
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    public BaseDao<RoleMenu> baseDao() {
        return roleMenuDao;
    }

    @Override
    public List<Integer> menuIdList(Integer roleId) {
        return roleMenuDao.menuIdList(roleId);
    }

    @Override
    public List<Menu> menuList(Integer roleId) {
        return roleMenuDao.menuList(roleId);
    }

    @Override
    public List<String> permitList(Integer roleId) {
        return roleMenuDao.permitList(roleId);
    }
}
