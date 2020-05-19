package com.fleet.common.service;

import java.util.List;
import java.util.Map;

import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;

public interface BaseService<T> {

	Boolean insert(T t);

	Boolean delete(T t);

	Boolean update(T t);

	T get(T t);

	List<T> list(Map<String, Object> map);

	PageUtil<T> listPage(Page page);

}
