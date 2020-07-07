package com.fleet.consumer.controller.admin.user;

import com.fleet.common.annotation.Log;
import com.fleet.common.entity.user.User;
import com.fleet.common.json.R;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.cache.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author April Han
 */
@RestController
@RequestMapping
public class LogoutController {

    @Resource
    RedisUtil redisUtil;

    @Log(value = "登出", type = 3)
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public R logout(HttpServletRequest request) {
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        if (StringUtils.isEmpty(accessToken)) {
            return R.error("缺少 accessToken");
        }

        User user = CurUser.getUser();
        if (user == null) {
            return R.error("当前用户不存在");
        }
        Integer id = user.getId();
        if (id == null) {
            return R.error("当前用户不存在");
        }
        clearToken(id);
        return R.ok();
    }

    public void clearToken(Integer id) {
        String refreshToken = (String) redisUtil.get("user:refreshToken:" + id);
        if (StringUtils.isNotEmpty(refreshToken)) {
            redisUtil.delete("refreshToken:user:" + refreshToken);
            String accessToken = (String) redisUtil.get("refreshToken:accessToken:" + refreshToken);
            if (StringUtils.isNotEmpty(accessToken)) {
                redisUtil.delete("accessToken:user:" + accessToken);
            }
            redisUtil.delete("refreshToken:accessToken:" + refreshToken);
        }
        redisUtil.delete("user:refreshToken:" + id);
    }
}
