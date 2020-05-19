package com.fleet.consumer.controller.admin.sys.user;

import com.fleet.common.enums.ResultState;
import com.fleet.common.enums.TokenExpiresIn;
import com.fleet.common.exception.BaseException;
import com.fleet.common.json.R;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.token.entity.Token;
import com.fleet.common.util.token.entity.UserToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 刷新token
     */
    @RequestMapping(value = "/refresh", method = {RequestMethod.GET, RequestMethod.POST})
    public R refresh(HttpServletRequest request) {
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
            Set<String> keys = redisUtil.keys("token:user:" + userId + ":refresh:" + refreshToken + ":*");
            UserToken userToken = null;
            if (keys != null) {
                for (String key : keys) {
                    userToken = (UserToken) redisUtil.get(key);
                    if (userToken != null) {
                        String accessToken = userToken.getAccessToken();
                        redisUtil.delete("token:access:" + accessToken);
                    }
                    redisUtil.delete(key);
                }
            }

            if (userToken == null) {
                userToken = new UserToken();
                userToken.setRefreshToken(refreshToken);
            }

            Long issuedAt = System.currentTimeMillis();
            String accessToken = UUIDUtil.getUUID();

            // 设置用户 accessToken 信息
            Token userAccessToken = new Token();
            userAccessToken.setUserId(userId);
            userAccessToken.setToken(accessToken);
            userAccessToken.setIssuedAt(issuedAt);
            userAccessToken.setExpiresIn(TokenExpiresIn.EXPIRES_IN.getMsec());
            redisUtil.set("token:access:" + accessToken, userAccessToken);

            // 更新用户 token 关联信息
            userToken.setAccessToken(accessToken);
            redisUtil.set("token:user:" + userId + ":refresh:" + refreshToken + ":access:" + accessToken, userToken);

            return R.ok(userToken);
        } else {
            return R.error(ResultState.REFRESH_TOKEN_INVALID);
        }
    }
}
