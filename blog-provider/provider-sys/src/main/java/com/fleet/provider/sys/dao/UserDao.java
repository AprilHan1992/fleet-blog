package com.fleet.provider.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.User;

@Mapper
@Repository
public interface UserDao extends BaseDao<User> {
}
