package com.fleet.provider.admin.dao;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.msg.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@Mapper
@Repository
public interface MsgDao extends BaseDao<Msg> {

    List<Msg> userMsgList(Map<String, Object> map);
}
