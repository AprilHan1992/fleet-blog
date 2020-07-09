package com.fleet.common.service.role;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.RoleMenu;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface RoleMenuService extends BaseService<RoleMenu> {

    List<Integer> idList(Integer roleId);

    List<Menu> menuList(Integer roleId);

    List<String> permitList(Integer roleId);
}
