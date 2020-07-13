package com.fleet.common.entity.activiti;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务信息
 */
public class TaskInfo<T> implements Serializable {

    private static final long serialVersionUID = 7220007461645369416L;

    /**
     * 流程编号（唯一）
     */
    private String businessKey;

    /**
     * 流程名称
     */
    private String processName;

    /**
     * 发起人
     */
    private String initiator;

    /**
     * 发起人电话
     */
    private String phone;

    /**
     * 发起人邮箱
     */
    private String email;

    /**
     * 流程发起时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date processStartTime;

    /**
     * 任务标识
     */
    private String taskId;

    /**
     * 任务节点名称
     */
    private String taskName;

    /**
     * 任务到达时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date taskCreateTime;

    /**
     * 当前节点审批人
     */
    private String currentAssigne;

    /**
     * 备注
     */
    private String remark;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getProcessStartTime() {
        return processStartTime;
    }

    public void setProcessStartTime(Date processStartTime) {
        this.processStartTime = processStartTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getCurrentAssigne() {
        return currentAssigne;
    }

    public void setCurrentAssigne(String currentAssigne) {
        this.currentAssigne = currentAssigne;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
