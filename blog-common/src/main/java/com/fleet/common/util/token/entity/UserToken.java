package com.fleet.common.util.token.entity;

import java.io.Serializable;

public class UserToken implements Serializable {

    private static final long serialVersionUID = 242170860090296421L;

    /**
     * accessToken 凭证
     */
    private String accessToken;

    /**
     * refreshToken 凭证
     */
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
