package com.fleet.consumer.controller.admin.sys.user;

import com.fleet.common.entity.user.UserRole;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.menu.MenuService;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/role")
public class UserRoleController {

    @Reference
    private UserRoleService userRoleService;

    @Reference
    private MenuService menuService;

    @RequestMapping("/insert")
    public R insert(@RequestBody UserRole userRole) {
        if (!userRoleService.insert(userRole)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/insert/batch")
    public R insertBatch(@RequestBody List<UserRole> userRoleList) {
        for (UserRole userRole : userRoleList) {
            if (!userRoleService.insert(userRole)) {
                return R.error();
            }
        }
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody UserRole userRole) {
        if (!userRoleService.delete(userRole)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    public R deleteBatch(@RequestBody List<UserRole> userRoleList) {
        for (UserRole userRole : userRoleList) {
            if (!userRoleService.delete(userRole)) {
                return R.error();
            }
        }
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody UserRole userRole) {
        if (!userRoleService.update(userRole)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/update/batch")
    public R updateBatch(@RequestBody List<UserRole> userRoleList) {
        for (UserRole userRole : userRoleList) {
            if (!userRoleService.update(userRole)) {
                return R.error();
            }
        }
        return R.ok();
    }

    @RequestMapping("/get")
    public R get(@RequestBody UserRole userRole) {
        return R.ok(userRoleService.get(userRole));
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(userRoleService.list(map));
    }

    @RequestMapping("/listPage")
    public PageUtil<UserRole> listPage(@RequestBody Page page) {
        return userRoleService.listPage(page);
    }
}
