package com.fleet.common.util.token.entity;

import java.io.Serializable;

public class Token implements Serializable {

    private static final long serialVersionUID = 5853982169357010227L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * token
     */
    private String token;

    /**
     * 签发时间戳
     */
    private Long issuedAt;

    /**
     * 过期时间（单位：毫秒）
     */
    private Long expiresIn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Long issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
