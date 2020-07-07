package com.fleet.provider.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.User;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface UserDao extends BaseDao<User> {
}
