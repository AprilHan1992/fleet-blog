package com.fleet.provider.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.role.Role;

@Mapper
@Repository
public interface RoleDao extends BaseDao<Role> {

	List<Integer> roleIdList(Role role);

}