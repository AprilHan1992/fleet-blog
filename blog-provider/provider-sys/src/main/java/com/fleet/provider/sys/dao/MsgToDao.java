package com.fleet.provider.sys.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.MsgTo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MsgToDao extends BaseDao<MsgTo> {
}
