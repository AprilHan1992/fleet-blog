package com.fleet.common.util.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.enums.ResultState;
import com.fleet.common.exception.BaseException;
import org.quartz.*;

public class QuartzUtil {

    private static final String JOB_KEY = "JOB_KEY_";

    /**
     * 获取 jobKey
     */
    public static JobKey getJobKey(Integer id) {
        return JobKey.jobKey(JOB_KEY + id);
    }

    /**
     * 获取触发器 key
     */
    public static TriggerKey getTriggerKey(Integer id) {
        return TriggerKey.triggerKey(JOB_KEY + id);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Integer id) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(id));
        } catch (SchedulerException e) {
            throw new BaseException("获取定时任务CronTrigger出现异常：" + e);
        }
    }

    /**
     * 创建定时任务
     */
    public static void addJob(Scheduler scheduler, QuartzJob job) {
        try {
            // 构建 job 信息
            JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class).withIdentity(getJobKey(job.getId())).build();
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            // 按新的 cronExpression 表达式构建一个新的 trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job.getId())).forJob(getJobKey(job.getId())).startNow().withSchedule(scheduleBuilder).build();
            // 放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(QuartzJob.JOB_PARAM_KEY, job);
            scheduler.scheduleJob(jobDetail, trigger);

            // 暂停任务
            if (job.getEnabledd().equals(0)) {
                pauseJob(scheduler, job.getId());
            }
        } catch (SchedulerException e) {
            throw new BaseException("定时任务创建失败：" + e);
        }
    }

    /**
     * 删除定时任务
     */
    public static void deleteJob(Scheduler scheduler, Integer id) {
        try {
            scheduler.pauseJob(getJobKey(id));
            scheduler.deleteJob(getJobKey(id));
        } catch (SchedulerException e) {
            throw new BaseException("定时任务删除失败：" + e);
        }
    }

    /**
     * 更新定时任务
     */
    public static void updateJob(Scheduler scheduler, QuartzJob job) {
        try {
            TriggerKey triggerKey = getTriggerKey(job.getId());
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            CronTrigger trigger = getCronTrigger(scheduler, job.getId());
            // 按新的 cronExpression 表达式重新构建 trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 参数
            trigger.getJobDataMap().put(QuartzJob.JOB_PARAM_KEY, job);
            scheduler.rescheduleJob(triggerKey, trigger);

            // 暂停任务
            if (job.getEnabledd().equals(0)) {
                pauseJob(scheduler, job.getId());
            }
        } catch (SchedulerException e) {
            throw new BaseException("定时任务更新失败：" + e);
        }
    }

    /**
     * 立即执行定时任务
     */
    public static void runJob(Scheduler scheduler, QuartzJob job) {
        try {
            // 参数
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(QuartzJob.JOB_PARAM_KEY, job);
            scheduler.triggerJob(getJobKey(job.getId()), dataMap);
        } catch (SchedulerException e) {
            throw new BaseException("立即执行定时任务失败：" + e);
        }
    }

    /**
     * 暂停定时任务
     */
    public static void pauseJob(Scheduler scheduler, Integer id) {
        try {
            scheduler.pauseJob(getJobKey(id));
        } catch (Exception e) {
            throw new BaseException("定时任务暂停失败：" + e);
        }
    }

    /**
     * 恢复定时任务
     */
    public static void resumeJob(Scheduler scheduler, Integer id) {
        try {
            scheduler.resumeJob(getJobKey(id));
        } catch (SchedulerException e) {
            throw new BaseException("定时任务恢复失败：" + e);
        }
    }
}
