package com.fleet.common.entity.form;

import com.fleet.common.entity.Base;

/**
 * 表单样式内容
 */
public class Style extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * 样式ID
	 */
	private Integer styleId;

	/**
	 * 布局ID
	 */
	private Integer layoutId;

	/**
	 * 样式
	 */
	private String style;

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	public Integer getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}