package com.fleet.consumer.controller.admin.sys.user;

import com.fleet.common.annotation.AuthCheck;
import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.User;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.service.menu.MenuService;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.MD5Util;
import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.cache.RedisUtil;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Reference
    private UserService userService;

    @Reference
    private UserRoleService userRoleService;

    @Reference
    private UserDeptService userDeptService;

    @Reference
    private MenuService menuService;

    @Reference
    private DeptService deptService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public BaseService<User> baseService() {
        return userService;
    }

    @AuthCheck(permits = {"aaa", "bbb"})
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody User user) {
        String salt = UUIDUtil.getUUID();
        user.setPwdSalt(salt);
        String password = MD5Util.encrypt(user.getUserPwd(), salt);
        user.setUserPwd(password);
        user.setUserRegTime(new Date());
        if (userService.insert(user)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("userId") Integer userId) {
        User user = new User();
        user.setUserId(userId);
        if (userService.delete(user)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping(value = "/delete/batch", method = RequestMethod.GET)
    public R deleteBatch(@RequestParam("userIds") List<Integer> userIds) {
        for (Integer userId : userIds) {
            User user = new User();
            user.setUserId(userId);
            if (!userService.delete(user)) {
                return R.error();
            }
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody User user) {
        if (user.getUserPwd() != null) {
            String salt = UUIDUtil.getUUID();
            user.setPwdSalt(salt);
            String password = MD5Util.encrypt(user.getUserPwd(), salt);
            user.setUserPwd(password);
        }
        if (userService.update(user)) {
            return R.ok();
        }
        return R.error();
    }

    @AuthCheck(permits = {"aaa", "bbb"})
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("userId") Integer userId) {
        User user = new User();
        user.setUserId(userId);
        return R.ok(get(user));
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public R get(@RequestBody User user) {
        user = userService.get(user);
        if (user != null) {
            Dept userDept = userDeptService.userDept(user.getUserId());
            user.setUserDept(userDept);

            List<Role> userRoleList = userRoleService.userRoleList(user.getUserId());
            user.setUserRoleList(userRoleList);
        }
        return R.ok(user);
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<User> listPage(@RequestBody Page page) {
        if (page.containsKey("deptId") && page.get("deptId") != null) {
            List<Integer> deptIdList = deptService.deptIdList((Integer) page.get("deptId"));
            page.remove("deptId");
            page.put("deptIdList", deptIdList);
        }
        PageUtil<User> pageUtil = userService.listPage(page);
        List<User> userList = pageUtil.getList();
        if (userList != null) {
            for (User user : userList) {
                Dept userDept = userDeptService.userDept(user.getUserId());
                user.setUserDept(userDept);

                List<Role> userRoleList = userRoleService.userRoleList(user.getUserId());
                user.setUserRoleList(userRoleList);
            }
        }
        return pageUtil;
    }

    @RequestMapping("/menuList")
    public R menuList() {
        Integer userId = getUserId();
        if (userId == null) {
            return R.ok(new ArrayList<>());
        }
        return R.ok(menuService.buildTree(userRoleService.userMenuList(userId)));
    }

    @RequestMapping("/userPermits")
    public R permitList() {
        Integer userId = getUserId();
        if (userId == null) {
            return R.ok(new ArrayList<>());
        }
        return R.ok(userRoleService.userPermits(userId));
    }

    @RequestMapping("/hasRoles")
    public Boolean hasRoles(Integer userId, String[] roles) {
        return userRoleService.hasRoles(userId, roles);
    }

    @RequestMapping("/hasPermits")
    public Boolean hasPermits(Integer userId, String[] permits) {
        return userRoleService.hasPermits(userId, permits);
    }
}
