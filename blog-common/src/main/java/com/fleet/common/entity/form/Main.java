package com.fleet.common.entity.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;

/**
 * 表单信息
 */
public class Main extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * 表单ID
	 */
	private Integer mainId;

	/**
	 * 分类ID
	 */
	private Integer typeId;

	/**
	 * 表单标识
	 */
	private String mainKey;

	/**
	 * 表单名称
	 */
	private String mainName;

	/**
	 * 备注
	 */
	private String mainRemark;

	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date mainCreateTime;

	/**
	 * 最后修改时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date mainEditTime;

	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getMainKey() {
		return mainKey;
	}

	public void setMainKey(String mainKey) {
		this.mainKey = mainKey;
	}

	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public String getMainRemark() {
		return mainRemark;
	}

	public void setMainRemark(String mainRemark) {
		this.mainRemark = mainRemark;
	}

	public Date getMainCreateTime() {
		return mainCreateTime;
	}

	public void setMainCreateTime(Date mainCreateTime) {
		this.mainCreateTime = mainCreateTime;
	}

	public Date getMainEditTime() {
		return mainEditTime;
	}

	public void setMainEditTime(Date mainEditTime) {
		this.mainEditTime = mainEditTime;
	}
}
