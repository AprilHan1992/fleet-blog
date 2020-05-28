package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.quartz.QuartzJobService;
import com.fleet.common.util.quartz.QuartzUtil;
import com.fleet.provider.sys.dao.QuartzJobDao;
import org.apache.dubbo.config.annotation.Service;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuartzJobServiceImpl extends BaseServiceImpl<QuartzJob> implements QuartzJobService {

    @Resource
    private QuartzJobDao jobDao;

    @Resource
    private Scheduler scheduler;

    @Override
    public BaseDao<QuartzJob> baseDao() {
        return jobDao;
    }

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        Map<String, Object> map = new HashMap<>();
        map.put("enabled", 1);
        map.put("deleted", Deleted.NO);
        List<QuartzJob> jobList = jobDao.list(map);
        if (jobList != null) {
            for (QuartzJob job : jobList) {
                CronTrigger cronTrigger = QuartzUtil.getCronTrigger(scheduler, job.getJobId());
                // 如果不存在，则创建
                if (cronTrigger == null) {
                    QuartzUtil.addJob(scheduler, job);
                } else {
                    QuartzUtil.updateJob(scheduler, job);
                }
            }
        }
    }

}
