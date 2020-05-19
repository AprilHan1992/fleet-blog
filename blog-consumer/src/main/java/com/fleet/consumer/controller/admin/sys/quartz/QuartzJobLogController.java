package com.fleet.consumer.controller.admin.sys.quartz;

import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.quartz.QuartzJobLogService;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quartz/jobLog")
public class QuartzJobLogController {

    @Reference
    private QuartzJobLogService quartzJobLogService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody QuartzJobLog quartzJobLog) {
        quartzJobLogService.insert(quartzJobLog);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("deptId") Integer jobLogId) {
        QuartzJobLog quartzJobLog = new QuartzJobLog();
        quartzJobLog.setJobLogId(jobLogId);
        quartzJobLogService.delete(quartzJobLog);
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("jobLogIds") List<Integer> jobLogIds) {
        for (Integer jobLogId : jobLogIds) {
            QuartzJobLog quartzJobLog = new QuartzJobLog();
            quartzJobLog.setJobLogId(jobLogId);
            quartzJobLogService.delete(quartzJobLog);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody QuartzJobLog quartzJobLog) {
        quartzJobLogService.update(quartzJobLog);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("deptId") Integer jobLogId) {
        QuartzJobLog quartzJobLog = new QuartzJobLog();
        quartzJobLog.setJobLogId(jobLogId);
        quartzJobLog = quartzJobLogService.get(quartzJobLog);
        return R.ok(quartzJobLog);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(quartzJobLogService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public R listPage(@RequestBody Page page) {
        return R.ok(quartzJobLogService.listPage(page));
    }

}
