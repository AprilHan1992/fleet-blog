package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.role.Role;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.role.RoleService;
import com.fleet.provider.admin.dao.RoleDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public BaseDao<Role> baseDao() {
        return roleDao;
    }

    @Override
    public Boolean delete(Role role) {
        List<Integer> roleIdList = roleDao.roleIdList(role);
        if (roleIdList != null) {
            roleDao.delete(role);
            for (Integer roleId : roleIdList) {
                Role r = new Role();
                r.setUpperId(roleId);
                delete(r);
            }
        }
        return true;
    }

    @Override
    public List<Role> buildTree(List<Role> roleList) {
        List<Role> tree = new ArrayList<>();
        if (roleList == null || roleList.isEmpty()) {
            return tree;
        }

        Map<Integer, Role> map = new HashMap<>();
        for (Role role : roleList) {
            map.put(role.getRoleId(), role);
        }

        for (Integer roleId : map.keySet()) {
            Role role = map.get(roleId);
            if (map.containsKey(role.getUpperId())) {
                Role upperRole = map.get(role.getUpperId());
                if (upperRole.getRoleList() == null) {
                    upperRole.setRoleList(new ArrayList<>());
                }
                upperRole.getRoleList().add(role);
            } else {
                tree.add(role);
            }
        }
        return tree;
    }
}
