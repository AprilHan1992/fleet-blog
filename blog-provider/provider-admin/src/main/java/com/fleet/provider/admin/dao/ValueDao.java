package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Value;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface ValueDao extends BaseDao<Value> {

    String getDefaultValue(String group);

    String getValue(@Param("group") String group, @Param("code") String code);
}
