package com.fleet.common.entity.app;

import java.io.Serializable;
import java.util.List;

public class AppType implements Serializable {

	private static final long serialVersionUID = -375255555043186662L;

	/**
	 * 应用分类标识
	 */
	private Integer appTypeId;

	/**
	 * 应用分类
	 */
	private String appType;

	/**
	 * 上一级应用分类标识
	 */
	private Integer upperAppTypeId;

	private List<AppType> appTypeList;

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

	public Integer getUpperAppTypeId() {
		return upperAppTypeId;
	}

	public void setUpperAppTypeId(Integer upperAppTypeId) {
		this.upperAppTypeId = upperAppTypeId;
	}

	public List<AppType> getAppTypeList() {
		return appTypeList;
	}

	public void setAppTypeList(List<AppType> appTypeList) {
		this.appTypeList = appTypeList;
	}
}
