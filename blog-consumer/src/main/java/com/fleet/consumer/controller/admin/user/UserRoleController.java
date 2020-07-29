package com.fleet.consumer.controller.admin.user;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.user.User;
import com.fleet.common.entity.user.UserRole;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.role.RoleService;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@RestController
@RequestMapping("/user/role")
public class UserRoleController extends BaseController<UserRole> {

    @Reference
    private UserRoleService userRoleService;

    @Reference
    private UserService userService;

    @Reference
    private RoleService roleService;

    @Override
    public BaseService<UserRole> baseService() {
        return userRoleService;
    }

    @Override
    @PostMapping("/update")
    public R update(@RequestBody UserRole userRole) {
        UserRole ur = new UserRole();
        ur.setUserId(userRole.getUserId());
        ur.setRoleId(userRole.getRoleId());
        ur = userRoleService.get(ur);
        if (ur != null && !ur.getId().equals(userRole.getId())) {
            return R.error("角色已存在");
        }
        if (!userRoleService.update(userRole)) {
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        UserRole userRole = new UserRole();
        userRole.setId(id);
        return get(userRole);
    }

    @Override
    @PostMapping("/get")
    public R get(@RequestBody UserRole userRole) {
        userRole = userRoleService.get(userRole);
        if (userRole != null) {
            User user = new User();
            user.setId(userRole.getUserId());
            userRole.setUser(userService.get(user));

            Role role = new Role();
            role.setId(userRole.getRoleId());
            userRole.setRole(roleService.get(role));
        }
        return R.ok(userRole);
    }

    @Override
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        List<UserRole> list = userRoleService.list(map);
        if (list != null) {
            for (UserRole userRole : list) {
                User user = new User();
                user.setId(userRole.getUserId());
                userRole.setUser(userService.get(user));

                Role role = new Role();
                role.setId(userRole.getRoleId());
                userRole.setRole(roleService.get(role));
            }
        }
        return R.ok(list);
    }

    @Override
    @PostMapping("/listPage")
    public PageUtil<UserRole> listPage(@RequestBody Page page) {
        PageUtil<UserRole> pageUtil = userRoleService.listPage(page);
        List<UserRole> list = pageUtil.getList();
        if (list != null) {
            for (UserRole userRole : list) {
                User user = new User();
                user.setId(userRole.getUserId());
                userRole.setUser(userService.get(user));

                Role role = new Role();
                role.setId(userRole.getRoleId());
                userRole.setRole(roleService.get(role));
            }
        }
        return pageUtil;
    }
}
