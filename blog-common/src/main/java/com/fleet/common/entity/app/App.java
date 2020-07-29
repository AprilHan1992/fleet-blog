package com.fleet.common.entity.app;

import java.util.Date;

import com.fleet.common.entity.Base;

public class App extends Base {

	private static final long serialVersionUID = 354203266314535432L;

	/**
	 * 应用标识
	 */
	private Long id;

	/**
	 * appId
	 */
	private String appId;

	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 分类（1：有appSecret，2：无appSecret），在不同场景下使用
	 */
	private Integer type;

	/**
	 * 应用分类标识
	 */
	private Integer appTypeId;

	/**
	 * 应用分类
	 */
	private String appType;

	/**
	 * appSecret
	 */
	private String appSecret;

	/**
	 * 创建时间
	 */
	private Date appCreateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAppTypeId() {
		return appTypeId;
	}

	public void setAppTypeId(Integer appTypeId) {
		this.appTypeId = appTypeId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public Date getAppCreateTime() {
		return appCreateTime;
	}

	public void setAppCreateTime(Date appCreateTime) {
		this.appCreateTime = appCreateTime;
	}
}
