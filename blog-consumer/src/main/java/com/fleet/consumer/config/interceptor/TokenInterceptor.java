package com.fleet.consumer.config.interceptor;

import com.fleet.common.entity.user.User;
import com.fleet.common.enums.ResultState;
import com.fleet.common.exception.BaseException;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.token.TokenUtil;
import com.fleet.common.util.token.entity.Token;
import com.fleet.common.util.token.entity.UserToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    @Reference
    private UserService userService;

    private List<String> refreshTokenPathPatterns = new ArrayList<>();

    /**
     * 设置 refreshToken 验证，refreshToken 验证后不再验证 accessToken
     */
    public void setRefreshTokenPathPatterns(String... patterns) {
        this.refreshTokenPathPatterns.addAll(Arrays.asList(patterns));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        if (this.refreshTokenPathPatterns.size() != 0) {
            if (this.refreshTokenPathPatterns.contains("/**") || this.refreshTokenPathPatterns.contains(uri)) {
                String refreshToken = request.getHeader("refreshToken");
                if (StringUtils.isEmpty(refreshToken)) {
                    refreshToken = request.getParameter("refreshToken");
                }
                if (StringUtils.isEmpty(refreshToken)) {
                    throw new BaseException(ResultState.REFRESH_TOKEN_MISSING);
                }
                Token userRefreshToken = (Token) redisUtil.get("token:refresh:" + refreshToken);
                if (userRefreshToken != null) {
                    Integer userId = userRefreshToken.getUserId();
                    if (!TokenUtil.isExpired(userRefreshToken.getIssuedAt(), userRefreshToken.getExpiresIn())) {
                        if (CurUser.getUser() == null) {
                            User user = new User();
                            user.setUserId(userId);
                            user = userService.get(user);
                            CurUser.setUser(user);
                        }
                        return true;
                    } else {
                        Set<String> keys = redisUtil.keys("token:user:" + userId + ":refresh:" + refreshToken + ":*");
                        if (keys != null) {
                            for (String key : keys) {
                                UserToken userToken = (UserToken) redisUtil.get(key);
                                if (userToken != null) {
                                    String accessToken = userToken.getAccessToken();
                                    redisUtil.delete("token:access:" + accessToken);
                                }
                                redisUtil.delete(key);
                            }
                        }
                        redisUtil.delete("token:refresh:" + refreshToken);
                        throw new BaseException(ResultState.REFRESH_TOKEN_EXPIRE);
                    }
                } else {
                    throw new BaseException(ResultState.REFRESH_TOKEN_INVALID);
                }
            }
        }

        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new BaseException(ResultState.ACCESS_TOKEN_MISSING);
        }
        Token userAccessToken = (Token) redisUtil.get("token:access:" + accessToken);
        if (userAccessToken != null) {
            Integer userId = userAccessToken.getUserId();
            if (!TokenUtil.isExpired(userAccessToken.getIssuedAt(), userAccessToken.getExpiresIn())) {
                if (CurUser.getUser() == null) {
                    User user = new User();
                    user.setUserId(userId);
                    user = userService.get(user);
                    CurUser.setUser(user);
                }
                return true;
            } else {
                throw new BaseException(ResultState.ACCESS_TOKEN_EXPIRE);
            }
        } else {
            throw new BaseException(ResultState.ACCESS_TOKEN_INVALID);
        }
    }
}
