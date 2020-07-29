package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface UserRoleDao extends BaseDao<UserRole> {

    List<Long> roleIdList(Long userId);

    List<Role> roleList(Long userId);

    List<String> roleNameList(Long userId);

    List<Menu> menuList(Long userId);

    List<String> permitList(Long userId);
}
