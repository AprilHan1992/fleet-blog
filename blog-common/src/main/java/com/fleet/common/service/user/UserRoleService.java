package com.fleet.common.service.user;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface UserRoleService extends BaseService<UserRole> {

    List<Role> userRoleList(Integer userId);

    List<String> userRoles(Integer userId);

    List<Menu> userMenuList(Integer userId);

    List<String> userPermits(Integer userId);

    Boolean hasRoles(Integer userId, String[] roles);

    Boolean hasPermits(Integer userId, String[] permits);
}
