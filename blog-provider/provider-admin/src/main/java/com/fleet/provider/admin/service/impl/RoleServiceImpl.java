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

/**
 * @author April Han
 */
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
        List<Integer> idList = roleDao.idList(role);
        if (idList != null) {
            roleDao.delete(role);
            for (Integer id : idList) {
                Role r = new Role();
                r.setUpperId(id);
                delete(r);
            }
        }
        return true;
    }

    @Override
    public Boolean deletes(Integer[] ids) {
        for (Integer id : ids) {
            Role role = new Role();
            role.setId(id);
            delete(role);
        }
        return true;
    }

    @Override
    public List<Integer> idList(Integer id) {
        List<Integer> rList = new ArrayList<>();
        rList.add(id);

        Role role = new Role();
        role.setUpperId(id);
        List<Integer> idList = roleDao.idList(role);
        if (idList != null) {
            for (Integer i : idList) {
                rList.addAll(idList(i));
            }
        }
        return rList;
    }

    @Override
    public List<Role> buildTree(List<Role> roleList) {
        List<Role> tree = new ArrayList<>();
        if (roleList == null || roleList.isEmpty()) {
            return tree;
        }

        Map<Integer, Role> map = new HashMap<>();
        for (Role role : roleList) {
            map.put(role.getId(), role);
        }

        for (Integer id : map.keySet()) {
            Role role = map.get(id);
            if (map.containsKey(role.getUpperId())) {
                Role upper = map.get(role.getUpperId());
                if (upper.getChildren() == null) {
                    upper.setChildren(new ArrayList<>());
                }
                upper.getChildren().add(role);
            } else {
                tree.add(role);
            }
        }
        return tree;
    }
}
