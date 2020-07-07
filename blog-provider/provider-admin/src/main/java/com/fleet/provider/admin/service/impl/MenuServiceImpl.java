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
        List<Integer> menuIdList = menuDao.menuIdList(menu);
        if (menuIdList != null && menuIdList.size() != 0) {
            for (Integer menuId : menuIdList) {
                Menu m = new Menu();
                m.setUpperId(menuId);
                delete(m);
            }
            menuDao.delete(menu);
        }
        return true;
    }

    @Override
    public List<Menu> buildTree(List<Menu> menuList) {
        List<Menu> tree = new ArrayList<>();
        if (menuList == null || menuList.isEmpty()) {
            return tree;
        }

        Map<Integer, Menu> map = new HashMap<>();
        for (Menu menu : menuList) {
            map.put(menu.getMenuId(), menu);
        }

        for (Integer menuId : map.keySet()) {
            Menu menu = map.get(menuId);
            if (map.containsKey(menu.getUpperId())) {
                Menu upperMenu = map.get(menu.getUpperId());
                if (upperMenu.getMenuList() == null) {
                    upperMenu.setMenuList(new ArrayList<>());
                }
                upperMenu.getMenuList().add(menu);
            } else {
                tree.add(menu);
            }
        }
        return tree;
    }

}
