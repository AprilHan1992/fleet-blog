package com.fleet.consumer.config.interceptor;

import com.fleet.common.entity.user.User;
import com.fleet.common.enums.ResultState;
import com.fleet.common.exception.BaseException;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.cache.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author April Han
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    @Reference
    private UserService userService;

    /**
     * 设置 refreshToken 验证，refreshToken 验证后不再验证 accessToken
     */
    private List<String> refreshTokenPatterns = new ArrayList<>();

    public TokenInterceptor() {
    }

    public TokenInterceptor(List<String> patternList) {
        this.refreshTokenPatterns.addAll(patternList);
    }

    public void setRefreshTokenPatterns(List<String> patternList) {
        this.refreshTokenPatterns.addAll(patternList);
    }

    public void setRefreshTokenPatterns(String... patterns) {
        this.refreshTokenPatterns.addAll(Arrays.asList(patterns));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        if (this.refreshTokenPatterns.size() != 0) {
            if (this.refreshTokenPatterns.contains("/**") || this.refreshTokenPatterns.contains(uri)) {
                String refreshToken = request.getHeader("refreshToken");
                if (StringUtils.isEmpty(refreshToken)) {
                    refreshToken = request.getParameter("refreshToken");
                }
                if (StringUtils.isEmpty(refreshToken)) {
                    throw new BaseException(ResultState.ERROR, "缺少 refreshToken");
                }

                Integer userId = (Integer) redisUtil.get("refreshToken:user:" + refreshToken);
                if (userId != null) {
                    if (CurUser.getUser() == null) {
                        User user = new User();
                        user.setId(userId);
                        user = userService.get(user);
                        CurUser.setUser(user);
                    }
                    return true;
                } else {
                    throw new BaseException("refreshToken 无效或已过期");
                }
            }
        }

        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new BaseException(ResultState.ERROR, "缺少 accessToken");
        }

        Integer userId = (Integer) redisUtil.get("accessToken:user:" + accessToken);
        if (userId != null) {
            if (CurUser.getUser() == null) {
                User user = new User();
                user.setId(userId);
                user = userService.get(user);
                CurUser.setUser(user);
            }
            return true;
        } else {
            throw new BaseException("accessToken 无效或已过期");
        }
    }
}
