package com.fleet.common.entity.base;

import java.io.Serializable;

public class Province implements Serializable {

	private static final long serialVersionUID = -2478709748506451760L;

	private Integer provinceId;

	private String province;

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
