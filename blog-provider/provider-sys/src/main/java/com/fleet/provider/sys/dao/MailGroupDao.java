package com.fleet.provider.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.mail.MailGroup;

@Mapper
@Repository
public interface MailGroupDao extends BaseDao<MailGroup> {
}