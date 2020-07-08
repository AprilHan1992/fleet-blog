package com.fleet.consumer.controller.admin.user;

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
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    RedisUtil redisUtil;

    @Override
    public BaseService<User> baseService() {
        return userService;
    }

    @Override
    @AuthCheck(permits = {"aaa", "bbb"})
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getName())) {
            return R.error("账户为空");
        }
        if (StringUtils.isEmpty(user.getPwd())) {
            return R.error("密码为空");
        }

        User u = new User();
        u.setName(user.getName());
        u = userService.get(u);
        if (u != null) {
            return R.error("账户已存在");
        }

        String salt = UUIDUtil.getUUID();
        user.setPwdSalt(salt);
        String pwd = MD5Util.encrypt(user.getPwd(), salt);
        user.setPwd(pwd);
        user.setRegTime(new Date());
        if (!userService.insert(user)) {
            return R.error();
        }
        return R.ok();
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody User user) {
        User u = new User();
        u.setId(user.getId());
        u = userService.get(u);
        if (u == null) {
            return R.error("账户不存在");
        }
        if (user.getPwd() != null) {
            String pwd = MD5Util.encrypt(user.getPwd(), u.getPwdSalt());
            user.setPwd(pwd);
        }
        if (!userService.update(user)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("id") Integer id) {
        User user = new User();
        user.setId(id);
        return R.ok(get(user));
    }

    @Override
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public R get(@RequestBody User user) {
        user = userService.get(user);
        if (user != null) {
            Dept dept = userDeptService.userDept(user.getId());
            user.setDept(dept);

            List<Role> roleList = userRoleService.userRoleList(user.getId());
            user.setRoleList(roleList);
        }
        return R.ok(user);
    }

    @Override
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<User> listPage(@RequestBody Page page) {
        if (page.containsKey("deptId") && page.get("deptId") != null) {
            List<Integer> deptIdList = deptService.idList((Integer) page.get("deptId"));
            page.remove("deptId");
            page.put("deptIdList", deptIdList);
        }
        PageUtil<User> pageUtil = userService.listPage(page);
        List<User> userList = pageUtil.getList();
        if (userList != null) {
            for (User user : userList) {
                Dept dept = userDeptService.userDept(user.getId());
                user.setDept(dept);

                List<Role> roleList = userRoleService.userRoleList(user.getId());
                user.setRoleList(roleList);
            }
        }
        return pageUtil;
    }

    @RequestMapping("/menuList")
    public R menuList() {
        Integer id = getUserId();
        if (id == null) {
            return R.ok(new ArrayList<>());
        }
        return R.ok(menuService.buildTree(userRoleService.userMenuList(id)));
    }

    @RequestMapping("/userPermits")
    public R permitList() {
        Integer id = getUserId();
        if (id == null) {
            return R.ok(new ArrayList<>());
        }
        return R.ok(userRoleService.userPermits(id));
    }

    @RequestMapping("/hasRoles")
    public Boolean hasRoles(Integer id, String[] roles) {
        return userRoleService.hasRoles(id, roles);
    }

    @RequestMapping("/hasPermits")
    public Boolean hasPermits(Integer id, String[] permits) {
        return userRoleService.hasPermits(id, permits);
    }
}
