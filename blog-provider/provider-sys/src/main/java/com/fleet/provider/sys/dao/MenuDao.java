package com.fleet.provider.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.menu.Menu;

@Mapper
@Repository
public interface MenuDao extends BaseDao<Menu> {

	List<Integer> menuIdList(Menu menu);

}