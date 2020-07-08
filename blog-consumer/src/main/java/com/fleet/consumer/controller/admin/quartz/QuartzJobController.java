package com.fleet.consumer.controller.admin.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.quartz.QuartzJobService;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.common.util.quartz.QuartzUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quartz/job")
public class QuartzJobController {

    @Resource
    private Scheduler scheduler;

    @Reference
    private QuartzJobService quartzJobService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody QuartzJob quartzJob) {
        if (!CronExpression.isValidExpression(quartzJob.getCronExpression())) {
            return R.error("cron表达式：" + quartzJob.getCronExpression() + "错误");
        }
        quartzJobService.insert(quartzJob);
        QuartzUtil.addJob(scheduler, quartzJob);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("jobId") Integer jobId) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId(jobId);
        quartzJobService.delete(quartzJob);
        QuartzUtil.deleteJob(scheduler, quartzJob.getJobId());
        return R.ok();
    }

    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    public R deletes(@RequestParam("jobIds") List<Integer> jobIds) {
        for (Integer jobId : jobIds) {
            QuartzJob quartzJob = new QuartzJob();
            quartzJob.setJobId(jobId);
            quartzJobService.delete(quartzJob);
            QuartzUtil.deleteJob(scheduler, quartzJob.getJobId());
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody QuartzJob quartzJob) {
        if (!CronExpression.isValidExpression(quartzJob.getCronExpression())) {
            return R.error("cron表达式：" + quartzJob.getCronExpression() + "错误");
        }
        quartzJobService.update(quartzJob);
        QuartzUtil.updateJob(scheduler, quartzJob);
        return R.ok();
    }

    @RequestMapping("/run/{jobId}")
    public R run(@PathVariable("jobId") Integer jobId) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId(jobId);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        QuartzUtil.runJob(scheduler, quartzJob);
        return R.ok();
    }

    @RequestMapping("/pause/{jobId}")
    public R pause(@PathVariable("jobId") Integer jobId) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId(jobId);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        QuartzUtil.pauseJob(scheduler, jobId);
        return R.ok();
    }

    @RequestMapping("/resume/{jobId}")
    public R restart(@PathVariable("jobId") Integer jobId) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId(jobId);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        QuartzUtil.resumeJob(scheduler, jobId);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@PathVariable("jobId") Integer jobId) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId(jobId);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        return R.ok(quartzJob);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(quartzJobService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public R listPage(@RequestBody Page page) {
        return R.ok(quartzJobService.listPage(page));
    }

}
