package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.DictValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface DictValueDao extends BaseDao<DictValue> {

    String getDefaultValue(String dictGroup);

    String getValue(@Param("dictGroup") String dictGroup, @Param("dictValueCode") String dictValueCode);
}
