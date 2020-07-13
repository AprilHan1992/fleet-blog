package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dict.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface DictDao extends BaseDao<Dict> {

    List<Integer> idList(Dict dict);

    String getDefaultValue(String group);

    String getValue(@Param("group") String group, @Param("code") String code);
}
