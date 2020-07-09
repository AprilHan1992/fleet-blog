package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface RoleDao extends BaseDao<Role> {

    List<Integer> idList(Role role);
}
