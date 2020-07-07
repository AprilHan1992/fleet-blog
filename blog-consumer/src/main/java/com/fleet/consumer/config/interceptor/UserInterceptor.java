package com.fleet.consumer.config.interceptor;

import com.fleet.common.entity.user.User;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.cache.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author April Han
 */
public class UserInterceptor implements HandlerInterceptor {

    @Resource
    RedisUtil redisUtil;

    @Reference
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String refreshToken = request.getHeader("refreshToken");
        if (StringUtils.isEmpty(refreshToken)) {
            refreshToken = request.getParameter("refreshToken");
        }
        if (StringUtils.isNotEmpty(refreshToken)) {
            Integer id = (Integer) redisUtil.get("refreshToken:user:" + refreshToken);
            if (id != null) {
                if (CurUser.getUser() == null) {
                    User user = new User();
                    user.setId(id);
                    user = userService.get(user);
                    CurUser.setUser(user);
                }
            }
        } else {
            String accessToken = request.getHeader("accessToken");
            if (StringUtils.isEmpty(accessToken)) {
                accessToken = request.getParameter("accessToken");
            }
            if (StringUtils.isNotEmpty(accessToken)) {
                Integer id = (Integer) redisUtil.get("accessToken:user:" + accessToken);
                if (id != null) {
                    if (CurUser.getUser() == null) {
                        User user = new User();
                        user.setId(id);
                        user = userService.get(user);
                        CurUser.setUser(user);
                    }
                }
            }
        }
        return true;
    }
}
