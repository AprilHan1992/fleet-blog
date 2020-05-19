package com.fleet.common.entity.quartz;

import com.fleet.common.entity.Base;

public class TaskSimJob extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * Job ID
	 */
	private Integer jobId;

	/**
	 * cron表达式
	 */
	private String cron;

	/**
	 * Job名称
	 */
	private String jobName;

	/**
	 * Job相关的类全名
	 */
	private String jobClassName;

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

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobClassName() {
		return jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
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
