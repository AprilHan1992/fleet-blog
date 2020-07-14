package com.fleet.consumer.controller.admin.quartz;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.quartz.QuartzJobService;
import org.apache.dubbo.config.annotation.Reference;
import org.quartz.CronExpression;
import org.springframework.web.bind.annotation.*;

/**
 * 定时任务
 *
 * @author April Han
 */
@RestController
@RequestMapping("/quartz/job")
public class QuartzJobController extends BaseController<QuartzJob> {

    @Reference
    private QuartzJobService quartzJobService;

    @Override
    public BaseService<QuartzJob> baseService() {
        return quartzJobService;
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
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        return R.ok(get(quartzJob));
    }

    /**
     * 启动
     *
     * @param id
     * @return
     */
    @RequestMapping("/run/{id}")
    public R run(@PathVariable("id") Integer id) {
        quartzJobService.run(id);
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
        quartzJobService.pause(id);
        return R.ok();
    }

    /**
     * 重启
     *
     * @param id
     * @return
     */
    @RequestMapping("/resume/{id}")
    public R resume(@PathVariable("id") Integer id) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        quartzJob = quartzJobService.get(quartzJob);
        if (quartzJob == null) {
            return R.error("定时任务不存在");
        }
        quartzJobService.resume(id);
        return R.ok();
    }
}
