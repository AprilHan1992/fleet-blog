package com.fleet.consumer.controller.admin.sys.user;

import com.fleet.common.annotation.Log;
import com.fleet.common.entity.user.User;
import com.fleet.common.enums.ResultState;
import com.fleet.common.enums.TokenExpiresIn;
import com.fleet.common.exception.BaseException;
import com.fleet.common.json.R;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.MD5Util;
import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.token.entity.Token;
import com.fleet.common.util.token.entity.UserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@Api(tags = "用户登录api")
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
     * @param userName 用户名
     * @param userPwd  密码
     */
    @Log(value = "登录", type = 1)
    @ApiOperation(value = "登录", notes = "登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "string"), @ApiImplicitParam(name = "userPwd", value = "密码", required = true, dataType = "string")})
    @GetMapping("/login")
    public R login(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd) {
        if (StringUtils.isEmpty(userName)) {
            return R.error(ResultState.PARAM_MISSING, "用户名为空");
        }
        if (StringUtils.isEmpty(userPwd)) {
            return R.error(ResultState.PARAM_MISSING, "密码为空");
        }

        User user = new User();
        user.setUserName(userName);
        user = userService.get(user);
        if (user == null) {
            throw new BaseException(ResultState.ACCOUNT_PASSWORD_ERROR);
        }

        String password = MD5Util.encrypt(userPwd, user.getPwdSalt());
        if (!password.equals(user.getUserPwd())) {
            throw new BaseException(ResultState.ACCOUNT_PASSWORD_ERROR);
        }

        if (user.getUserState().equals(0)) {
            throw new BaseException(ResultState.ACCOUNT_NOT_ALLOWED);
        }
        if (user.getUserState().equals(2)) {
            throw new BaseException(ResultState.ACCOUNT_LOCKED);
        }

        Integer userId = user.getUserId();
        Integer single = user.getSingle();
        if (single.equals(1)) {
            Set<String> keys = redisUtil.keys("token:user:" + userId + ":*");
            if (keys != null) {
                for (String key : keys) {
                    UserToken userToken = (UserToken) redisUtil.get(key);
                    if (userToken != null) {
                        redisUtil.delete("token:access:" + userToken.getAccessToken());
                        redisUtil.delete("token:refresh:" + userToken.getRefreshToken());
                    }
                    redisUtil.delete(key);
                }
            }
        }

        UserToken userToken = setUserToken(userId);
        return R.ok(userToken);
    }

    public UserToken setUserToken(Integer userId) {
        Long issuedAt = System.currentTimeMillis();
        String accessToken = UUIDUtil.getUUID();
        String refreshToken = UUIDUtil.getUUID();

        // 设置用户 accessToken 信息
        Token userAccessToken = new Token();
        userAccessToken.setUserId(userId);
        userAccessToken.setToken(accessToken);
        userAccessToken.setIssuedAt(issuedAt);
        userAccessToken.setExpiresIn(TokenExpiresIn.EXPIRES_IN.getMsec());
        redisUtil.set("token:access:" + accessToken, userAccessToken);

        // 设置用户 refreshToken 信息
        Token userRefreshToken = new Token();
        userRefreshToken.setUserId(userId);
        userRefreshToken.setToken(refreshToken);
        userRefreshToken.setIssuedAt(issuedAt);
        userRefreshToken.setExpiresIn(TokenExpiresIn.REFRESH_EXPIRES_IN.getMsec());
        redisUtil.set("token:refresh:" + refreshToken, userRefreshToken);

        // 设置用户 token 关联信息
        UserToken userToken = new UserToken();
        userToken.setAccessToken(accessToken);
        userToken.setRefreshToken(refreshToken);
        redisUtil.set("token:user:" + userId + ":refresh:" + refreshToken + ":access:" + accessToken, userToken);

        return userToken;
    }
}
