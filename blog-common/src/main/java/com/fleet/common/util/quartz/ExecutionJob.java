package com.fleet.common.util.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.service.quartz.QuartzJobLogService;
import com.fleet.common.util.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.util.Date;

public class ExecutionJob extends QuartzJobBean {

    @Reference
    private QuartzJobLogService quartzJobLogService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        QuartzJob quartzJob = (QuartzJob) context.getMergedJobDataMap().get(QuartzJob.JOB_PARAM_KEY);
        QuartzJobLog quartzJobLog = new QuartzJobLog();
        quartzJobLog.setJobId(quartzJob.getJobId());
        quartzJobLog.setJobName(quartzJob.getJobName());
        quartzJobLog.setBeanName(quartzJob.getBeanName());
        quartzJobLog.setMethodName(quartzJob.getMethodName());
        quartzJobLog.setParams(quartzJob.getParams());
        quartzJobLog.setCronExpression(quartzJob.getCronExpression());

        long startTimeMillis = System.currentTimeMillis();
        try {
            Object target = SpringContextUtil.getBean(quartzJob.getBeanName());
            if (StringUtils.isNotBlank(quartzJob.getParams())) {
                Method method = target.getClass().getDeclaredMethod(quartzJob.getMethodName(), String.class);
                method.invoke(target, quartzJob.getParams());
            } else {
                Method method = target.getClass().getDeclaredMethod(quartzJob.getMethodName());
                method.invoke(target);
            }
            long millis = System.currentTimeMillis() - startTimeMillis;
            quartzJobLog.setState(1);
            quartzJobLog.setMillis(millis);
            saveLog(quartzJobLog);
        } catch (Exception e) {
            long millis = System.currentTimeMillis() - startTimeMillis;
            quartzJobLog.setState(0);
            quartzJobLog.setError(e.getMessage());
            quartzJobLog.setMillis(millis);
            saveLog(quartzJobLog);
        } finally {
        }
    }

    @Async
    void saveLog(QuartzJobLog quartzJobLog) {
        quartzJobLog.setCreateTime(new Date());
        quartzJobLogService.insert(quartzJobLog);
    }

}
