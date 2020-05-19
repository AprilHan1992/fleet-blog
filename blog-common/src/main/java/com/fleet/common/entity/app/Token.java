package com.fleet.common.entity.app;

import java.io.Serializable;

public class Token implements Serializable {

	private static final long serialVersionUID = -2206692792592316472L;

	/**
	 * accessToken 凭证
	 */
	private String accessToken;

	/**
	 * 有效期（单位：秒）
	 */
	private Long expires;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

}
