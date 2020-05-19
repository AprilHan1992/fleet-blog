package com.fleet.provider.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.DictValue;

@Mapper
@Repository
public interface DictValueDao extends BaseDao<DictValue> {

	String getDefaultValue(String dictGroup);

	String getValue(@Param("dictGroup") String dictGroup, @Param("dictValueCode") String dictValueCode);

}
