package com.fleet.consumer.controller.admin.user;

import com.fleet.common.entity.role.RoleMenu;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.role.RoleMenuService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role/menu")
public class RoleMenuController {

    @Reference
    private RoleMenuService roleMenuService;

    @RequestMapping("/insert")
    public R insert(@RequestBody RoleMenu roleMenu) {
        List<Integer> menuIdList = roleMenu.getMenuIdList();
        if (menuIdList != null) {
            for (Integer menuId : menuIdList) {
                RoleMenu rp = new RoleMenu();
                rp.setRoleId(roleMenu.getRoleId());
                rp.setMenuId(menuId);
                roleMenuService.insert(rp);
            }
        }
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody RoleMenu roleMenu) {
        roleMenuService.delete(roleMenu);
        return R.ok();
    }

    @RequestMapping(value = "/deletes", method = RequestMethod.POST)
    public R deletes(@RequestBody List<RoleMenu> roleMenuList) {
        for (RoleMenu roleMenu : roleMenuList) {
            roleMenuService.delete(roleMenu);
        }
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody RoleMenu roleMenu) {
        RoleMenu rp = new RoleMenu();
        rp.setRoleId(roleMenu.getRoleId());
        roleMenuService.delete(rp);
        List<Integer> menuIdList = roleMenu.getMenuIdList();
        if (menuIdList != null) {
            for (Integer menuId : menuIdList) {
                rp = new RoleMenu();
                rp.setRoleId(roleMenu.getRoleId());
                rp.setMenuId(menuId);
                roleMenuService.update(rp);
            }
        }
        return R.ok();
    }

    @RequestMapping("/get")
    public RoleMenu get(@RequestBody RoleMenu roleMenu) {
        return roleMenuService.get(roleMenu);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(roleMenuService.list(map));
    }

    @RequestMapping("/listPage")
    public PageUtil<RoleMenu> listPage(@RequestBody Page page) {
        PageUtil<RoleMenu> pageUtil = roleMenuService.listPage(page);
        return pageUtil;
    }

    @RequestMapping("/menuList")
    public R menuList(@RequestParam Integer roleId) {
        return R.ok(roleMenuService.menuList(roleId));
    }

    @RequestMapping("/permitList")
    public R permitList(@RequestParam Integer roleId) {
        return R.ok(roleMenuService.permitList(roleId));
    }

}
