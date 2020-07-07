package com.fleet.consumer.controller.admin.user;

import com.fleet.common.entity.user.User;
import com.fleet.common.enums.ResultState;
import com.fleet.common.exception.BaseException;
import com.fleet.common.json.R;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.MD5Util;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pwd")
public class PwdController {

    @Reference
    UserService userService;

    @Resource
    RedisUtil redisUtil;

    /**
     * 登陆
     *
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     */
    @RequestMapping("/change")
    public R login(@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd) {
        if (StringUtils.isEmpty(oldPwd)) {
            throw new BaseException("旧密码为空");
        }
        if (StringUtils.isEmpty(newPwd)) {
            throw new BaseException("新密码为空");
        }

        // 当前用户
        User cur = CurUser.getUser();
        if (cur == null) {
            throw new BaseException(ResultState.ERROR);
        }

        String password = MD5Util.encrypt(oldPwd, cur.getPwdSalt());
        if (!password.equals(cur.getPwd())) {
            throw new BaseException(ResultState.ERROR);
        }

        User user = new User();
        user.setId(cur.getId());

        // 生成新密码
        String salt = UUIDUtil.getUUID();
        user.setPwdSalt(salt);
        password = MD5Util.encrypt(newPwd, salt);
        user.setPwd(password);
        userService.update(user);

        return R.ok();
    }
}
