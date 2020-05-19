package com.fleet.common.service.menu;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface MenuService extends BaseService<Menu> {

    List<Menu> buildTree(List<Menu> menuList);
}
