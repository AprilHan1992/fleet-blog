package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.menu.MenuService;
import com.fleet.provider.admin.dao.MenuDao;
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
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public BaseDao<Menu> baseDao() {
        return menuDao;
    }

    @Override
    public Boolean delete(Menu menu) {
        List<Integer> idList = menuDao.idList(menu);
        if (idList != null && idList.size() != 0) {
            menuDao.delete(menu);
            for (Integer id : idList) {
                Menu m = new Menu();
                m.setUpperId(id);
                delete(m);
            }
        }
        return true;
    }

    @Override
    public Boolean deletes(Integer[] ids) {
        for (Integer id : ids) {
            Menu menu = new Menu();
            menu.setId(id);
            delete(menu);
        }
        return true;
    }

    @Override
    public List<Integer> idList(Integer id) {
        List<Integer> rList = new ArrayList<>();
        rList.add(id);

        Menu menu = new Menu();
        menu.setUpperId(id);
        List<Integer> idList = menuDao.idList(menu);
        if (idList != null) {
            for (Integer i : idList) {
                rList.addAll(idList(i));
            }
        }
        return rList;
    }

    @Override
    public List<Menu> buildTree(List<Menu> menuList) {
        List<Menu> tree = new ArrayList<>();
        if (menuList == null || menuList.isEmpty()) {
            return tree;
        }

        Map<Integer, Menu> map = new HashMap<>();
        for (Menu menu : menuList) {
            map.put(menu.getId(), menu);
        }

        for (Integer id : map.keySet()) {
            Menu menu = map.get(id);
            if (map.containsKey(menu.getUpperId())) {
                Menu upper = map.get(menu.getUpperId());
                if (upper.getChildren() == null) {
                    upper.setChildren(new ArrayList<>());
                }
                upper.getChildren().add(menu);
            } else {
                tree.add(menu);
            }
        }
        return tree;
    }
}
