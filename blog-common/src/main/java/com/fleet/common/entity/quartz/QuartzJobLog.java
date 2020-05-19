package com.fleet.common.entity.quartz;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;

public class QuartzJobLog extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * 日志id
	 */
	private Integer jobLogId;

	/**
	 * 任务id
	 */
	private Integer jobId;

	/**
	 * 定时器名称
	 */
	private String jobName;

	/**
	 * Bean名称
	 */
	private String beanName;

	/**
	 * 方法名称
	 */
	private String methodName;

	/**
	 * 参数
	 */
	private String params;

	/**
	 * cron表达式
	 */
	private String cronExpression;

	/**
	 * 任务状态 （1：成功，0：失败）
	 */
	private Integer state;

	/**
	 * 失败信息
	 */
	private String error;

	/**
	 * 执行时间（单位：毫秒）
	 */
	private Long millis;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	public Integer getJobLogId() {
		return jobLogId;
	}

	public void setJobLogId(Integer jobLogId) {
		this.jobLogId = jobLogId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getMillis() {
		return millis;
	}

	public void setMillis(Long millis) {
		this.millis = millis;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
