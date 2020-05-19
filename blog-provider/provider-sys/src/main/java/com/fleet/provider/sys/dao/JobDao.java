package com.fleet.provider.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.job.Job;

@Mapper
@Repository
public interface JobDao extends BaseDao<Job> {

	List<Integer> jobIdList(Job job);

	List<Job> listByUserId(Integer userId);

}