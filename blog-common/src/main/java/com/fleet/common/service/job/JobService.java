package com.fleet.common.service.job;

import com.fleet.common.entity.job.Job;
import com.fleet.common.service.BaseService;

import java.util.List;

public interface JobService extends BaseService<Job> {

    List<Job> listById(Integer id);

    List<Job> buildTree(List<Job> jobList);
}
