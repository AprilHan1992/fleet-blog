package com.fleet.common.entity.form;

import com.fleet.common.entity.Base;

/**
 * 表单分类
 */
public class Type extends Base {

	private static final long serialVersionUID = 684689427829571991L;

	/**
	 * 分类ID
	 */
	private Integer typeId;

	/**
	 * 分类名称
	 */
	private String typeName;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
