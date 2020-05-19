package com.fleet.common.util.token;

public class TokenUtil {

    /**
     * 检查时间戳是否过期
     */
    public static Boolean isExpired(Long issuedAt, Long expiresIn) {
        if ((System.currentTimeMillis() - issuedAt) > expiresIn) {
            return true;
        }
        return false;
    }
}
