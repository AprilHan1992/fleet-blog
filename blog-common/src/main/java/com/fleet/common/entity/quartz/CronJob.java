package com.fleet.common.entity.quartz;

import com.fleet.common.entity.Base;

public class CronJob extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * Job ID
	 */
	private Integer jobId;

	/**
	 * cron表达式
	 */
	private String cronExpression;

	/**
	 * Job名称
	 */
	private String jobName;

	/**
	 * Job组
	 */
	private String jobGroup;

	/**
	 * Job相关的类名
	 */
	private String jobClass;

	/**
	 * Job相关的方法名
	 */
	private String jobFunction;

	/**
	 * Job描述
	 */
	private String jobDescription;

	/**
	 * 是否启用（1：是，0：否）
	 */
	private Integer enabled;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Integer getEnabledd() {
		return enabled;
	}

	public void setEnabledd(Integer enabled) {
		this.enabled = enabled;
	}
}
