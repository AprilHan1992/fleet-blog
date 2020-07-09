package com.fleet.consumer.controller.admin.quartz;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.quartz.QuartzJobLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务记录
 *
 * @author April Han
 */
@RestController
@RequestMapping("/quartz/jobLog")
public class QuartzJobLogController extends BaseController<QuartzJobLog> {

    @Reference
    private QuartzJobLogService quartzJobLogService;

    @Override
    public BaseService<QuartzJobLog> baseService() {
        return quartzJobLogService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        QuartzJobLog quartzJobLog = new QuartzJobLog();
        quartzJobLog.setId(id);
        return get(quartzJobLog);
    }
}
