package com.fleet.provider.sys.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleDao extends BaseDao<UserRole> {

    List<Role> userRoleList(Integer userId);

    List<String> userRoles(Integer userId);

    List<Menu> userMenuList(Integer userId);

    List<String> userPermits(Integer userId);
}
