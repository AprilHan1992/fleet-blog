package com.fleet.common.entity.quartz;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;

import java.util.Date;

/**
 * @author April Han
 */
public class QuartzJobLog extends Base {

    private static final long serialVersionUID = 4069607703129526255L;

    /**
     * 日志id
     */
    private Long id;

    /**
     * 任务id
     */
    private Long jobId;

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
    private String param;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
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
