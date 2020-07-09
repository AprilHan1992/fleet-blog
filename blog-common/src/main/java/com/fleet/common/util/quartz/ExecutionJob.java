package com.fleet.common.util.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.entity.quartz.QuartzJobLog;
import com.fleet.common.util.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author April Han
 */
public class ExecutionJob extends QuartzJobBean {

    @Resource
    private JobLogAsyncTask jobLogAsyncTask;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        QuartzJob quartzJob = (QuartzJob) context.getMergedJobDataMap().get(QuartzJob.JOB_PARAM_KEY);
        QuartzJobLog quartzJobLog = new QuartzJobLog();
        quartzJobLog.setId(quartzJob.getId());
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
            jobLogAsyncTask.saveLog(quartzJobLog);
        } catch (Exception e) {
            long millis = System.currentTimeMillis() - startTimeMillis;
            quartzJobLog.setState(0);
            quartzJobLog.setError(e.getMessage());
            quartzJobLog.setMillis(millis);
            jobLogAsyncTask.saveLog(quartzJobLog);
        } finally {
        }
    }
}
