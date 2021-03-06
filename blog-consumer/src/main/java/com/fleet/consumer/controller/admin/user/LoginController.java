package com.fleet.consumer.controller.admin.user;

import com.fleet.common.annotation.Log;
import com.fleet.common.entity.user.User;
import com.fleet.common.enums.TokenExpiresIn;
import com.fleet.common.enums.UserState;
import com.fleet.common.json.R;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.MD5Util;
import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.cache.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author April Han
 */
@RestController
@RequestMapping
public class LoginController {

    @Reference
    UserService userService;

    @Resource
    RedisUtil redisUtil;

    /**
     * 登陆
     *
     * @param name 用户名
     * @param pwd  密码
     */
    @Log(value = "登录", type = 1)
    @GetMapping("/login")
    public R login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        if (StringUtils.isEmpty(name)) {
            return R.error("用户名为空");
        }
        if (StringUtils.isEmpty(pwd)) {
            return R.error("密码为空");
        }

        User user = new User();
        user.setName(name);
        user = userService.get(user);
        if (user == null) {
            return R.error("用户名或密码错误");
        }

        pwd = MD5Util.encrypt(pwd, user.getPwdSalt());
        if (!pwd.equals(user.getPwd())) {
            return R.error("用户名或密码错误");
        }
        if (user.getState().equals(UserState.FORBIDDEN)) {
            return R.error("用户名被禁用");
        }
        if (user.getState().equals(UserState.LOCKED)) {
            return R.error("用户名被锁定");
        }

        Long userId = user.getId();
        clearToken(userId);
        Map<String, Object> tokenMap = initToken(userId);
        return R.ok(tokenMap);
    }

    public void clearToken(Long userId) {
        String refreshToken = (String) redisUtil.get("user:refreshToken:" + userId);
        if (StringUtils.isNotEmpty(refreshToken)) {
            redisUtil.delete("refreshToken:user:" + refreshToken);
            String accessToken = (String) redisUtil.get("refreshToken:accessToken:" + refreshToken);
            if (StringUtils.isNotEmpty(accessToken)) {
                redisUtil.delete("accessToken:user:" + accessToken);
            }
            redisUtil.delete("refreshToken:accessToken:" + refreshToken);
        }
        redisUtil.delete("user:refreshToken:" + userId);
    }

    public Map<String, Object> initToken(Long userId) {
        Map<String, Object> tokenMap = new HashMap<>();
        String refreshToken = UUIDUtil.getUUID();
        String accessToken = UUIDUtil.getUUID();
        redisUtil.setEx("user:refreshToken:" + userId, refreshToken, TokenExpiresIn.REFRESH_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
        redisUtil.setEx("refreshToken:user:" + refreshToken, userId, TokenExpiresIn.REFRESH_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
        redisUtil.setEx("refreshToken:accessToken:" + refreshToken, accessToken, TokenExpiresIn.ACCESS_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
        redisUtil.setEx("accessToken:user:" + accessToken, userId, TokenExpiresIn.ACCESS_EXPIRES_IN.getSec(), TimeUnit.SECONDS);
        tokenMap.put("refreshToken", refreshToken);
        tokenMap.put("accessToken", accessToken);
        return tokenMap;
    }
}
