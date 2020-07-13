package com.fleet.common.entity.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;

/**
 * 数据表字段
 */
public class Field extends Base {

	private static final long serialVersionUID = -2805588221252171447L;

	/**
	 * 字段ID
	 */
	private Integer fieldId;

	/**
	 * 数据表ID
	 */
	private Integer tableId;

	/**
	 * 标识
	 */
	private String fieldKey;

	/**
	 * 名称
	 */
	private String fieldName;

	/**
	 * 是否必须输入（1：是，0：否）
	 */
	private Integer fieldIsRequired;

	/**
	 * 注释
	 */
	private String fieldComment;

	/**
	 * 字段类型（1：数字，2：字符串，3：多行文本，4：富文本框，5：日期时间，6：单选，7：多选，8：下拉框，9：多选下拉框，10：文件上传）
	 */
	private String fieldType;

	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fieldCreateTime;

	/**
	 * 最后修改时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fieldEditTime;

	private FieldAddition addition;

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getFieldIsRequired() {
		return fieldIsRequired;
	}

	public void setFieldIsRequired(Integer fieldIsRequired) {
		this.fieldIsRequired = fieldIsRequired;
	}

	public String getFieldComment() {
		return fieldComment;
	}

	public void setFieldComment(String fieldComment) {
		this.fieldComment = fieldComment;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Date getFieldCreateTime() {
		return fieldCreateTime;
	}

	public void setFieldCreateTime(Date fieldCreateTime) {
		this.fieldCreateTime = fieldCreateTime;
	}

	public Date getFieldEditTime() {
		return fieldEditTime;
	}

	public void setFieldEditTime(Date fieldEditTime) {
		this.fieldEditTime = fieldEditTime;
	}

	public FieldAddition getAddition() {
		return addition;
	}

	public void setAddition(FieldAddition addition) {
		this.addition = addition;
	}
}
