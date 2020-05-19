package com.fleet.common.entity.mail;

import com.fleet.common.entity.Base;

public class MailGroup extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * 邮箱组id
	 */
	private Integer mailGroupId;

	/**
	 * 邮箱组名称
	 */
	private String mailGroupName;

	/**
	 * 邮箱（多个邮箱之间用","隔开）
	 */
	private String mailGroupTo;

	public Integer getMailGroupId() {
		return mailGroupId;
	}

	public void setMailGroupId(Integer mailGroupId) {
		this.mailGroupId = mailGroupId;
	}

	public String getMailGroupName() {
		return mailGroupName;
	}

	public void setMailGroupName(String mailGroupName) {
		this.mailGroupName = mailGroupName;
	}

	public String getMailGroupTo() {
		return mailGroupTo;
	}

	public void setMailGroupTo(String mailGroupTo) {
		this.mailGroupTo = mailGroupTo;
	}

}
