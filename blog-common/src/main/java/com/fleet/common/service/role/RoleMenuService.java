package com.fleet.common.service.role;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.RoleMenu;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface RoleMenuService extends BaseService<RoleMenu> {

    List<Long> menuIdList(Long roleId);

    List<Menu> menuList(Long roleId);

    List<String> permitList(Long roleId);
}
