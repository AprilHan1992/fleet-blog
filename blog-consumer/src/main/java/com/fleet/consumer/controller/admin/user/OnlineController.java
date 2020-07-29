package com.fleet.consumer.controller.admin.user;

import com.fleet.common.entity.user.User;
import com.fleet.common.json.R;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 在线用户
 *
 * @author April Han
 */
@RestController
@RequestMapping("/online")
public class OnlineController {

    @Reference
    private UserService userService;

    @Resource
    RedisUtil redisUtil;

    @PostMapping("/listPage")
    public PageUtil<User> onlineListPage(@RequestBody Page page) {
        PageUtil<User> pageUtil = new PageUtil<>();
        Set<String> keys = redisUtil.keys("refreshToken:user:*");
        List<User> list = new ArrayList<>();
        if (keys != null) {
            List<String> keyList = new ArrayList<>(keys);
            page.setTotalRows(keyList.size());
            keyList = keyList.subList(page.getFromPageIndex(), page.getToPageIndex());
            for (String key : keyList) {
                Long id = (Long) redisUtil.get(key);
                User user = new User();
                user.setId(id);
                list.add(userService.get(user));
            }
        }
        pageUtil.setList(list);
        pageUtil.setPage(page);
        return pageUtil;
    }

    /**
     * 强制退出
     */
    @GetMapping("/delete")
    public R delete(@RequestParam("id") Long id) {
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
        return R.ok();
    }

    /**
     * 批量强制退出
     */
    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    public R deletes(@RequestParam Long[] ids) {
        for (Long id : ids) {
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
        return R.ok();
    }
}
