package com.fleet.common.service.menu;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface MenuService extends BaseService<Menu> {

    /**
     * 获取所有 menuId 集合（包括）
     */
    List<Integer> idList(Integer id);

    List<Menu> buildTree(List<Menu> menuList);
}
