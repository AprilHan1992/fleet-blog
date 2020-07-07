package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.job.Job;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.job.JobService;
import com.fleet.provider.admin.dao.JobDao;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService {

    @Resource
    private JobDao jobDao;

    @Override
    public BaseDao<Job> baseDao() {
        return jobDao;
    }

    @Override
    public Boolean delete(Job job) {
        List<Integer> jobIdList = jobDao.jobIdList(job);
        if (jobIdList != null && jobIdList.size() != 0) {
            jobDao.delete(job);
            for (Integer jobId : jobIdList) {
                Job m = new Job();
                m.setUpperId(jobId);
                delete(m);
            }
        }
        return true;
    }

    @Override
    public List<Job> listById(Integer id) {
        return jobDao.listById(id);
    }

    @Override
    public List<Job> buildTree(List<Job> jobList) {
        List<Job> tree = new ArrayList<>();
        if (jobList == null || jobList.isEmpty()) {
            return tree;
        }

        Map<Integer, Job> map = new HashMap<>();
        for (Job job : jobList) {
            map.put(job.getJobId(), job);
        }

        for (Integer jobId : map.keySet()) {
            Job job = map.get(jobId);
            if (map.containsKey(job.getUpperId())) {
                Job upperJob = map.get(job.getUpperId());
                if (upperJob.getJobList() == null) {
                    upperJob.setJobList(new ArrayList<>());
                }
                upperJob.getJobList().add(job);
            } else {
                tree.add(job);
            }
        }

        return tree;
    }

}
