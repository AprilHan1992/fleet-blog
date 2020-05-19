package com.fleet.common.entity.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;

/**
 * 数据表
 */
public class Table extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * 数据表ID
	 */
	private Integer tableId;

	/**
	 * 表单ID
	 */
	private Integer mainId;

	/**
	 * 上一级ID
	 */
	private Integer tableParentId;

	/**
	 * 数据表名称
	 */
	private String tableName;

	/**
	 * 数据表备注
	 */
	private String tableRemark;

	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tableCreateTime;

	/**
	 * 最后修改时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tableEditTime;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	public Integer getTableParentId() {
		return tableParentId;
	}

	public void setTableParentId(Integer tableParentId) {
		this.tableParentId = tableParentId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableRemark() {
		return tableRemark;
	}

	public void setTableRemark(String tableRemark) {
		this.tableRemark = tableRemark;
	}

	public Date getTableCreateTime() {
		return tableCreateTime;
	}

	public void setTableCreateTime(Date tableCreateTime) {
		this.tableCreateTime = tableCreateTime;
	}

	public Date getTableEditTime() {
		return tableEditTime;
	}

	public void setTableEditTime(Date tableEditTime) {
		this.tableEditTime = tableEditTime;
	}

}