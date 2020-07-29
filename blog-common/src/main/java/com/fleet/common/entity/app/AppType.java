package com.fleet.common.entity.app;

import java.io.Serializable;
import java.util.List;

public class AppType implements Serializable {

	private static final long serialVersionUID = -375255555043186662L;

	/**
	 * 应用分类标识
	 */
	private Long appTypeId;

	/**
	 * 应用分类
	 */
	private String appType;

	/**
	 * 上一级应用分类标识
	 */
	private Long upperAppTypeId;

	private List<AppType> appTypeList;

	public Long getAppTypeId() {
		return appTypeId;
	}

	public void setAppTypeId(Long appTypeId) {
		this.appTypeId = appTypeId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Long getUpperAppTypeId() {
		return upperAppTypeId;
	}

	public void setUpperAppTypeId(Long upperAppTypeId) {
		this.upperAppTypeId = upperAppTypeId;
	}

	public List<AppType> getAppTypeList() {
		return appTypeList;
	}

	public void setAppTypeList(List<AppType> appTypeList) {
		this.appTypeList = appTypeList;
	}
}
