package com.fleet.consumer.config.quartz;

import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.service.quartz.QuartzJobLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务日志记录
 *
 * @author April Han
 */
@Component
public class JobLogAsyncTask {

    @Reference
    private QuartzJobLogService quartzJobLogService;

    @Async
    void saveLog(QuartzJobLog quartzJobLog) {
        quartzJobLog.setCreateTime(new Date());
        quartzJobLogService.insert(quartzJobLog);
    }
}
