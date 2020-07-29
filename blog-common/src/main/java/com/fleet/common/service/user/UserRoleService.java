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

    List<Long> roleIdList(Long userId);

    List<Role> roleList(Long userId);

    List<Menu> menuList(Long userId);

    List<String> permitList(Long userId);

    Boolean hasRoles(Long userId, String[] roles);

    Boolean hasPermits(Long userId, String[] permits);
}
