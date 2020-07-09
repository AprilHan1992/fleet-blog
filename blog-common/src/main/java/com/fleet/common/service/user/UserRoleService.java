package com.fleet.common.service.user;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.service.BaseService;

import java.util.List;

/**
 * @author April Han
 */
public interface UserRoleService extends BaseService<UserRole> {

    List<Integer> idList(UserRole userRole);

    List<Role> roleList(Integer userId);

    List<Menu> menuList(Integer userId);

    List<String> permitList(Integer userId);

    Boolean hasRoles(Integer userId, String[] roles);

    Boolean hasPermits(Integer userId, String[] permits);
}
