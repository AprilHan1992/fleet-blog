package com.fleet.common.entity.test;

import com.fleet.common.entity.Base;

public class Test extends Base {

	private static final long serialVersionUID = 1L;

	/**
	 * 测试id
	 */
	private Integer testId;

	/**
	 * 测试名
	 */
	private String testName;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

}
