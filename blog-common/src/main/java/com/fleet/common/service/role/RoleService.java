package com.fleet.common.service.role;

import com.fleet.common.entity.role.Role;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    /**
     * 获取所有 roleId 集合（包括）
     */
    List<Long> idList(Long id);

    List<Role> buildTree(List<Role> roleList);
}
