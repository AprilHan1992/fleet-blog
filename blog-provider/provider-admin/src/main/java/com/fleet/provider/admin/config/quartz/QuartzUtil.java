package com.fleet.provider.admin.config.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.exception.BaseException;
import org.quartz.*;

/**
 * @author April Han
 */
public class QuartzUtil {

    private static final String JOB_KEY = "JOB_KEY_";

    private static final String JOB_GROUP = "JOB_GROUP";

    private static final String TRIGGER_KEY = "TRIGGER_KEY_";

    private static final String TRIGGER_GROUP = "TRIGGER_GROUP";

    /**
     * 创建定时任务
     */
    public static void insert(Scheduler scheduler, QuartzJob job) {
        try {
            JobKey jobKey = getJobKey(job.getId());
            TriggerKey triggerKey = getTriggerKey(job.getId());
            JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class)
                    .withIdentity(jobKey)
                    .withDescription(job.getJobName())
                    .build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey)
                    .forJob(jobKey)
                    .withDescription(job.getJobName())
                    .withSchedule(cronScheduleBuilder)
                    .startNow()
                    .build();
            jobDetail.getJobDataMap().put(QuartzJob.JOB_PARAM_KEY, job);
            scheduler.scheduleJob(jobDetail, trigger);
            if (job.getEnabled().equals(0)) {
                pause(scheduler, job.getId());
            } else {
                if (!scheduler.isShutdown()) {
                    scheduler.start();
                }
            }
        } catch (SchedulerException e) {
            throw new BaseException("创建定时任务失败：" + e);
        }
    }

    /**
     * 删除定时任务
     */
    public static void delete(Scheduler scheduler, Long id) {
        try {
            JobKey jobKey = getJobKey(id);
            TriggerKey triggerKey = getTriggerKey(id);
            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            // 删除任务
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            throw new BaseException("删除定时任务失败：" + e);
        }
    }

    /**
     * 更新定时任务
     */
    public static void update(Scheduler scheduler, QuartzJob job) {
        try {
            JobKey jobKey = getJobKey(job.getId());
            TriggerKey triggerKey = getTriggerKey(job.getId());
            if (scheduler.checkExists(triggerKey)) {
                // 停止触发器
                scheduler.pauseTrigger(triggerKey);
                // 移除触发器
                scheduler.unscheduleJob(triggerKey);
            }
            if (scheduler.checkExists(jobKey)) {
                scheduler.pauseJob(jobKey);
                // 删除任务
                scheduler.deleteJob(jobKey);
            }
            JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class)
                    .withIdentity(jobKey)
                    .withDescription(job.getJobName())
                    .build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey)
                    .forJob(jobKey)
                    .withDescription(job.getJobName())
                    .withSchedule(cronScheduleBuilder)
                    .startNow()
                    .build();
            jobDetail.getJobDataMap().put(QuartzJob.JOB_PARAM_KEY, job);
            scheduler.scheduleJob(jobDetail, trigger);
            if (job.getEnabled().equals(0)) {
                pause(scheduler, job.getId());
            } else {
                if (!scheduler.isShutdown()) {
                    scheduler.start();
                }
            }
        } catch (SchedulerException e) {
            throw new BaseException("更新定时任务失败：" + e);
        }
    }

    /**
     * 更新定时任务 cron 表达式
     */
    public static void update(Scheduler scheduler, Long id, String cronExpression) {
        try {
            TriggerKey triggerKey = getTriggerKey(id);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            CronTrigger trigger = getCronTrigger(scheduler, id);
            trigger = trigger.getTriggerBuilder()
                    .withIdentity(triggerKey)
                    .withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            throw new BaseException("更新定时任务 cron 表达式失败：" + e);
        }
    }

    /**
     * 立即执行定时任务
     */
    public static void run(Scheduler scheduler, Long id) {
        try {
            JobKey jobKey = getJobKey(id);
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            throw new BaseException("立即执行定时任务失败：" + e);
        }
    }

    /**
     * 暂停定时任务
     */
    public static void pause(Scheduler scheduler, Long id) {
        try {
            JobKey jobKey = getJobKey(id);
            TriggerKey triggerKey = getTriggerKey(id);
            scheduler.pauseJob(jobKey);
            scheduler.pauseTrigger(triggerKey);
        } catch (Exception e) {
            throw new BaseException("暂停定时任务失败：" + e);
        }
    }

    /**
     * 恢复定时任务
     */
    public static void resume(Scheduler scheduler, Long id) {
        try {
            JobKey jobKey = getJobKey(id);
            TriggerKey triggerKey = getTriggerKey(id);
            scheduler.resumeJob(jobKey);
            scheduler.resumeTrigger(triggerKey);
        } catch (SchedulerException e) {
            throw new BaseException("恢复定时任务失败：" + e);
        }
    }

    /**
     * 启动定时器
     */
    public static void start(Scheduler scheduler) {
        try {
            scheduler.start();
        } catch (Exception e) {
            throw new BaseException("启动定时器失败：" + e);
        }
    }

    /**
     * 关闭定时器
     */
    public static void shutdown(Scheduler scheduler) {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new BaseException("关闭定时器失败：" + e);
        }
    }

    /**
     * 获取 jobKey
     */
    public static JobKey getJobKey(Long id) {
        return new JobKey(JOB_KEY + id, JOB_GROUP);
    }

    /**
     * 获取触发器 key
     */
    public static TriggerKey getTriggerKey(Long id) {
        return new TriggerKey(TRIGGER_KEY + id, TRIGGER_GROUP);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long id) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(id));
        } catch (SchedulerException e) {
            throw new BaseException("获取定时任务CronTrigger出现异常：" + e);
        }
    }
}
