package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.enums.Deleted;
import com.fleet.common.enums.Enabled;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.quartz.QuartzJobService;
import com.fleet.provider.admin.config.quartz.QuartzUtil;
import com.fleet.provider.admin.dao.QuartzJobDao;
import org.apache.dubbo.config.annotation.Service;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@Service
public class QuartzJobServiceImpl extends BaseServiceImpl<QuartzJob> implements QuartzJobService {

    @Resource
    private QuartzJobDao quartzJobDao;

    @Override
    public BaseDao<QuartzJob> baseDao() {
        return quartzJobDao;
    }

    @Resource
    private Scheduler scheduler;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        Map<String, Object> map = new HashMap<>();
        map.put("deleted", Deleted.NO);
        map.put("enabled", Enabled.YES);
        List<QuartzJob> list = quartzJobDao.list(map);
        if (list != null) {
            for (QuartzJob job : list) {
                CronTrigger trigger = QuartzUtil.getCronTrigger(scheduler, job.getId());
                // 如果不存在，则创建
                if (trigger == null) {
                    QuartzUtil.insert(scheduler, job);
                } else {
                    QuartzUtil.update(scheduler, job);
                }
            }
        }
    }

    @Override
    public Boolean insert(QuartzJob quartzJob) {
        if (quartzJobDao.insert(quartzJob) == 0) {
            return false;
        }
        QuartzUtil.insert(scheduler, quartzJob);
        return true;
    }

    @Override
    public Boolean delete(QuartzJob quartzJob) {
        List<Long> idList = quartzJobDao.idList(quartzJob);
        if (idList != null && idList.size() != 0) {
            if (quartzJobDao.delete(quartzJob) == 0) {
                return false;
            }
            for (Long id : idList) {
                QuartzUtil.delete(scheduler, id);
            }
        }
        return true;
    }

    @Override
    public Boolean deletes(Long[] ids) {
        if (quartzJobDao.deletes(ids) == 0) {
            return false;
        }
        for (Long id : ids) {
            QuartzUtil.delete(scheduler, id);
        }
        return true;
    }

    @Override
    public Boolean update(QuartzJob quartzJob) {
        if (quartzJobDao.update(quartzJob) == 0) {
            return false;
        }
        QuartzUtil.update(scheduler, quartzJob);
        return true;
    }

    @Override
    public void run(Long id) {
        QuartzUtil.run(scheduler, id);
    }

    @Override
    public void pause(Long id) {
        QuartzUtil.pause(scheduler, id);
    }

    @Override
    public void resume(Long id) {
        QuartzUtil.resume(scheduler, id);
    }
}
