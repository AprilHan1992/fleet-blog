package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface RoleMenuDao extends BaseDao<RoleMenu> {

    List<Integer> idList(RoleMenu roleMenu);

    List<Menu> menuList(Integer roleId);

    List<String> permitList(Integer roleId);
}
