package com.fleet.consumer.controller.admin.quartz;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.enums.Deleted;
import com.fleet.common.enums.Enabled;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.quartz.QuartzJobService;
import com.fleet.common.util.quartz.QuartzUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author April Han
 */
@RestController
@RequestMapping("/quartz/job")
public class QuartzJobController extends BaseController<QuartzJob> {

    @Resource
    private Scheduler scheduler;

    @Reference
    private QuartzJobService quartzJobService;

    @Override
    public BaseService<QuartzJob> baseService() {
        return quartzJobService;
    }

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        Map<String, Object> map = new HashMap<>();
        map.put("deleted", Deleted.NO);
        map.put("enabled", Enabled.YES);
        List<QuartzJob> list = quartzJobService.list(map);
        if (list != null) {
            for (QuartzJob job : list) {
                CronTrigger cronTrigger = QuartzUtil.getCronTrigger(scheduler, job.getId());
                // 如果不存在，则创建
                if (cronTrigger == null) {
                    QuartzUtil.addJob(scheduler, job);
                } else {
                    QuartzUtil.updateJob(scheduler, job);
                }
            }
        }
    }

    @Override
    @PostMapping("/insert")
    public R insert(@RequestBody QuartzJob quartzJob) {
        if (!CronExpression.isValidExpression(quartzJob.getCronExpression())) {
            return R.error("cron表达式：" + quartzJob.getCronExpression() + "错误");
        }
        if (!quartzJobService.insert(quartzJob)) {
            return R.error();
        }
        QuartzUtil.addJob(scheduler, quartzJob);
        return R.ok();
    }

    @Override
    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    public R deletes(@RequestParam Integer[] ids) {
        for (Integer id : ids) {
            QuartzJob quartzJob = new QuartzJob();
            quartzJob.setId(id);
            quartzJobService.delete(quartzJob);
            QuartzUtil.deleteJob(scheduler, quartzJob.getId());
        }
        return R.ok();
    }

    @Override
    @PostMapping("/update")
    public R update(@RequestBody QuartzJob quartzJob) {
        if (!CronExpression.isValidExpression(quartzJob.getCronExpression())) {
            return R.error("cron表达式：" + quartzJob.getCronExpression() + "错误");
        }
        if (!quartzJobService.update(quartzJob)) {
            return R.error();
        }
        QuartzUtil.updateJob(scheduler, quartzJob);
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        return R.ok(quartzJob);
    }

    /**
     * 启动
     *
     * @param id
     * @return
     */
    @RequestMapping("/run/{id}")
    public R run(@PathVariable("id") Integer id) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        QuartzUtil.runJob(scheduler, quartzJob);
        return R.ok();
    }

    /**
     * 暂停
     *
     * @param id
     * @return
     */
    @RequestMapping("/pause/{id}")
    public R pause(@PathVariable("id") Integer id) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        QuartzUtil.pauseJob(scheduler, id);
        return R.ok();
    }

    /**
     * 重启
     *
     * @param id
     * @return
     */
    @RequestMapping("/resume/{id}")
    public R restart(@PathVariable("id") Integer id) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        QuartzUtil.resumeJob(scheduler, id);
        return R.ok();
    }
}
