package com.fleet.common.entity.form;

import java.io.Serializable;

/**
 * 数据表字段附加属性
 */
public class FieldAddition implements Serializable {

	private static final long serialVersionUID = -1311703984803168887L;

	/**
	 * 字段ID
	 */
	private Integer fieldId;

	/**
	 * 长度
	 */
	private Integer fieldLength;

	/**
	 * 小数位
	 */
	private Integer fieldDecimal;

	/**
	 * 默认值
	 */
	private String fieldDefaultValue;

	/**
	 * 层级(主要针对一级或多级下拉框)
	 */
	private Integer fieldLevel;

	/**
	 * 选项
	 */
	private String fieldOption;

	/**
	 * 验证规则
	 */
	private String fieldValidRule;

	/**
	 * 计算公式
	 */
	private String fieldFormula;

	/**
	 * 格式化
	 */
	private String fieldFormat;

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Integer getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(Integer fieldLength) {
		this.fieldLength = fieldLength;
	}

	public Integer getFieldDecimal() {
		return fieldDecimal;
	}

	public void setFieldDecimal(Integer fieldDecimal) {
		this.fieldDecimal = fieldDecimal;
	}

	public String getFieldDefaultValue() {
		return fieldDefaultValue;
	}

	public void setFieldDefaultValue(String fieldDefaultValue) {
		this.fieldDefaultValue = fieldDefaultValue;
	}

	public Integer getFieldLevel() {
		return fieldLevel;
	}

	public void setFieldLevel(Integer fieldLevel) {
		this.fieldLevel = fieldLevel;
	}

	public String getFieldOption() {
		return fieldOption;
	}

	public void setFieldOption(String fieldOption) {
		this.fieldOption = fieldOption;
	}

	public String getFieldValidRule() {
		return fieldValidRule;
	}

	public void setFieldValidRule(String fieldValidRule) {
		this.fieldValidRule = fieldValidRule;
	}

	public String getFieldFormula() {
		return fieldFormula;
	}

	public void setFieldFormula(String fieldFormula) {
		this.fieldFormula = fieldFormula;
	}

	public String getFieldFormat() {
		return fieldFormat;
	}

	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}
}
