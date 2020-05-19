package com.fleet.common.util.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.enums.ResultState;
import com.fleet.common.exception.BaseException;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

public class QuartzUtil {

	private static final String JOB_KEY = "JOB_KEY_";

	/**
	 * 获取 jobKey
	 */
	public static JobKey getJobKey(Integer jobId) {
		return JobKey.jobKey(JOB_KEY + jobId);
	}

	/**
	 * 获取触发器 key
	 */
	public static TriggerKey getTriggerKey(Integer jobId) {
		return TriggerKey.triggerKey(JOB_KEY + jobId);
	}

	/**
	 * 获取表达式触发器
	 */
	public static CronTrigger getCronTrigger(Scheduler scheduler, Integer jobId) {
		try {
			return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
		} catch (SchedulerException e) {
			throw new BaseException(ResultState.FAILED, "获取定时任务CronTrigger出现异常：" + e);
		}
	}

	/**
	 * 创建定时任务
	 */
	public static void addJob(Scheduler scheduler, QuartzJob job) {
		try {
			// 构建 job 信息
			JobDetail jobDetail = JobBuilder.newJob(ExecutionJob.class).withIdentity(getJobKey(job.getJobId())).build();
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			// 按新的 cronExpression 表达式构建一个新的 trigger
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job.getJobId())).forJob(getJobKey(job.getJobId())).startNow().withSchedule(scheduleBuilder).build();
			// 放入参数，运行时的方法可以获取
			jobDetail.getJobDataMap().put(QuartzJob.JOB_PARAM_KEY, job);
			scheduler.scheduleJob(jobDetail, trigger);

			// 暂停任务
			if (job.getEnabledd().equals(0)) {
				pauseJob(scheduler, job.getJobId());
			}
		} catch (SchedulerException e) {
			throw new BaseException(ResultState.FAILED, "定时任务创建失败：" + e);
		}
	}

	/**
	 * 删除定时任务
	 */
	public static void deleteJob(Scheduler scheduler, Integer jobId) {
		try {
			scheduler.pauseJob(getJobKey(jobId));
			scheduler.deleteJob(getJobKey(jobId));
		} catch (SchedulerException e) {
			throw new BaseException(ResultState.FAILED, "定时任务删除失败：" + e);
		}
	}

	/**
	 * 更新定时任务
	 */
	public static void updateJob(Scheduler scheduler, QuartzJob job) {
		try {
			TriggerKey triggerKey = getTriggerKey(job.getJobId());
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			CronTrigger trigger = getCronTrigger(scheduler, job.getJobId());
			// 按新的 cronExpression 表达式重新构建 trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 参数
			trigger.getJobDataMap().put(QuartzJob.JOB_PARAM_KEY, job);
			scheduler.rescheduleJob(triggerKey, trigger);

			// 暂停任务
			if (job.getEnabledd().equals(0)) {
				pauseJob(scheduler, job.getJobId());
			}
		} catch (SchedulerException e) {
			throw new BaseException(ResultState.FAILED, "定时任务更新失败：" + e);
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
			scheduler.triggerJob(getJobKey(job.getJobId()), dataMap);
		} catch (SchedulerException e) {
			throw new BaseException(ResultState.FAILED, "立即执行定时任务失败：" + e);
		}
	}

	/**
	 * 暂停定时任务
	 */
	public static void pauseJob(Scheduler scheduler, Integer jobId) {
		try {
			scheduler.pauseJob(getJobKey(jobId));
		} catch (Exception e) {
			throw new BaseException(ResultState.FAILED, "定时任务暂停失败：" + e);
		}
	}

	/**
	 * 恢复定时任务
	 */
	public static void resumeJob(Scheduler scheduler, Integer jobId) {
		try {
			scheduler.resumeJob(getJobKey(jobId));
		} catch (SchedulerException e) {
			throw new BaseException(ResultState.FAILED, "定时任务恢复失败：" + e);
		}
	}

}
