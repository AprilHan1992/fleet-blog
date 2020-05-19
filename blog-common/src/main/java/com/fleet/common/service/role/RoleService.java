package com.fleet.common.service.role;

import com.fleet.common.entity.role.Role;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    List<Role> buildTree(List<Role> roleList);
}
