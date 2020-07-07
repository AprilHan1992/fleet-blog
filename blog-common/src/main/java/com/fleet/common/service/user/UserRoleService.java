package com.fleet.common.service.user;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface UserRoleService extends BaseService<UserRole> {

    List<Role> userRoleList(Integer id);

    List<String> userRoles(Integer id);

    List<Menu> userMenuList(Integer id);

    List<String> userPermits(Integer id);

    Boolean hasRoles(Integer id, String[] roles);

    Boolean hasPermits(Integer id, String[] permits);
}
