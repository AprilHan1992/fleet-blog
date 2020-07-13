package com.fleet.common.entity.activiti;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 流程信息
 */
public class ProcessInfo<T> implements Serializable {

	private static final long serialVersionUID = -7264165955117621066L;

	/**
	 * 流程标识
	 */
	private String processId;

	/**
	 * 流程类型
	 */
	private String definitionKey;

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
	 * 流程详情
	 */
	T details;

	/**
	 * 流程备注
	 */
	private String remark;

	/**
	 * 当前节点审批人
	 */
	private String currentAssigne;

	/**
	 * 审批人
	 */
	private Map<String, String> assignees;

	/**
	 * 流程发起时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date processStartTime;

	/**
	 * 流程结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date processEndTime;

	/**
	 * 流程状态（1：进行中，2：已结案，3：已终止）
	 */
	private Integer state;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getDefinitionKey() {
		return definitionKey;
	}

	public void setDefinitionKey(String definitionKey) {
		this.definitionKey = definitionKey;
	}

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

	public T getDetails() {
		return details;
	}

	public void setDetails(T details) {
		this.details = details;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCurrentAssigne() {
		return currentAssigne;
	}

	public void setCurrentAssigne(String currentAssigne) {
		this.currentAssigne = currentAssigne;
	}

	public Map<String, String> getAssignees() {
		return assignees;
	}

	public void setAssignees(Map<String, String> assignees) {
		this.assignees = assignees;
	}

	public Date getProcessStartTime() {
		return processStartTime;
	}

	public void setProcessStartTime(Date processStartTime) {
		this.processStartTime = processStartTime;
	}

	public Date getProcessEndTime() {
		return processEndTime;
	}

	public void setProcessEndTime(Date processEndTime) {
		this.processEndTime = processEndTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
