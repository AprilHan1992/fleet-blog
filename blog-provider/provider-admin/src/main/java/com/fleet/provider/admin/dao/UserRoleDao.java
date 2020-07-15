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

    List<Integer> roleIdList(Integer userId);

    List<Role> roleList(Integer userId);

    List<String> roleNameList(Integer userId);

    List<Menu> menuList(Integer userId);

    List<String> permitList(Integer userId);
}
