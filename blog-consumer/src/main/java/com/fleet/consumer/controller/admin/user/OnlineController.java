package com.fleet.consumer.controller.admin.user;

import com.fleet.common.entity.user.User;
import com.fleet.common.json.R;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.date.DateUtil;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import com.fleet.common.util.token.TokenUtil;
import com.fleet.common.util.token.entity.Token;
import com.fleet.common.util.token.entity.UserToken;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 在线用户
 */
@RestController
@RequestMapping("/user/online")
public class OnlineController {

    @Reference
    private UserService userService;

    @Resource
    RedisUtil redisUtil;

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Map<String, Object>> onlineListPage(@RequestBody Page page) {
        PageUtil<Map<String, Object>> pageUtil = new PageUtil<>();
        Set<String> keys = redisUtil.keys("token:refresh:*");
        List<Map<String, Object>> list = new ArrayList<>();
        if (keys != null) {
            List<String> keyList = new ArrayList<>(keys);
            page.setTotalRows(keyList.size());
            keyList = keyList.subList(page.getFromPageIndex(), page.getToPageIndex());
            for (String key : keyList) {
                Map<String, Object> map = new HashMap<>();
                Token token = (Token) redisUtil.get(key);
                map.put("token", token.getToken());
                map.put("loginTime", DateUtil.format(token.getIssuedAt(), DateUtil.FMT_DATETIMES));

                User user = new User();
                user.setId(token.getId());
                user = userService.get(user);
                if (user != null) {
                    map.put("id", user.getId());
                    map.put("name", user.getName());
                    map.put("nickName", user.getNickName());
                }
                list.add(map);
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }

    /**
     * 强制退出
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("token") String token) {
        Token userRefreshToken = (Token) redisUtil.get("token:refresh:" + token);
        if (userRefreshToken != null) {
            Integer id = userRefreshToken.getId();
            Set<String> keys = redisUtil.keys("token:user:" + id + ":refresh:" + token + ":*");
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
            redisUtil.delete("token:refresh:" + token);
        }
        return R.ok();
    }

    /**
     * 批量强制退出
     */
    @RequestMapping(value = "/deletes", method = RequestMethod.GET)
    public R deletes(@RequestParam("tokens") List<String> tokens) {
        for (String token : tokens) {
            Token userRefreshToken = (Token) redisUtil.get("token:refresh:" + token);
            if (userRefreshToken != null) {
                Integer id = userRefreshToken.getId();
                Set<String> keys = redisUtil.keys("token:user:" + id + ":refresh:" + token + ":*");
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
                redisUtil.delete("token:refresh:" + token);
            }
        }
        return R.ok();
    }

    /**
     * 清理过期
     */
    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public R clean() {
        Set<String> keys = redisUtil.keys("token:refresh:*");
        if (keys != null) {
            for (String key : keys) {
                Token userRefreshToken = (Token) redisUtil.get(key);
                if (userRefreshToken != null) {
                    if (TokenUtil.isExpired(userRefreshToken.getIssuedAt(), userRefreshToken.getExpiresIn())) {
                        Integer id = userRefreshToken.getId();
                        String refreshToken = userRefreshToken.getToken();
                        Set<String> ks = redisUtil.keys("token:user:" + id + ":refresh:" + refreshToken + ":*");
                        if (ks != null) {
                            for (String k : ks) {
                                UserToken userToken = (UserToken) redisUtil.get(k);
                                if (userToken != null) {
                                    String accessToken = userToken.getAccessToken();
                                    redisUtil.delete("token:access:" + accessToken);
                                }
                                redisUtil.delete(k);
                            }
                        }
                        redisUtil.delete("token:refresh:" + refreshToken);
                    }
                }
            }
        }
        return R.ok();
    }
}
