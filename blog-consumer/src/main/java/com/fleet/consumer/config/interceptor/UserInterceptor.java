package com.fleet.consumer.config.interceptor;

import com.fleet.common.entity.user.User;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.token.entity.Token;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    RedisUtil redisUtil;

    @Reference
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        if (StringUtils.isNotEmpty(accessToken)) {
            Token userAccessToken = (Token) redisUtil.get("token:access:" + accessToken);
            if (userAccessToken != null) {
                User user = new User();
                user.setUserId(userAccessToken.getUserId());
                user = userService.get(user);
                CurUser.setUser(user);
            }
        }
        return true;
    }
}
