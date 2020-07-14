package com.fleet.consumer.controller.admin.role;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
import com.fleet.common.entity.role.RoleMenu;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.menu.MenuService;
import com.fleet.common.service.role.RoleMenuService;
import com.fleet.common.service.role.RoleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角色对应菜单管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/role/menu")
public class RoleMenuController extends BaseController<RoleMenu> {

    @Reference
    private RoleMenuService roleMenuService;

    @Reference
    private RoleService roleService;

    @Reference
    private MenuService menuService;

    @Override
    public BaseService<RoleMenu> baseService() {
        return roleMenuService;
    }

    @Override
    @PostMapping("/update")
    public R update(@RequestBody RoleMenu roleMenu) {
        RoleMenu rm = new RoleMenu();
        rm.setRoleId(roleMenu.getRoleId());
        rm.setMenuId(roleMenu.getMenuId());
        rm = roleMenuService.get(rm);
        if (rm != null && !rm.getId().equals(roleMenu.getId())) {
            return R.error("菜单已存在");
        }
        if (!roleMenuService.update(roleMenu)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(id);
        return get(roleMenu);
    }

    @Override
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        List<RoleMenu> list = roleMenuService.list(map);
        if (list != null) {
            for (RoleMenu roleMenu : list) {
                Role role = new Role();
                role.setId(roleMenu.getRoleId());
                roleMenu.setRole(roleService.get(role));

                Menu menu = new Menu();
                menu.setId(roleMenu.getMenuId());
                roleMenu.setMenu(menuService.get(menu));
            }
        }
        return R.ok(list);
    }

    @Override
    @PostMapping("/listPage")
    public PageUtil<RoleMenu> listPage(@RequestBody Page page) {
        PageUtil<RoleMenu> pageUtil = roleMenuService.listPage(page);
        List<RoleMenu> list = pageUtil.getList();
        if (list != null) {
            for (RoleMenu roleMenu : list) {
                Role role = new Role();
                role.setId(roleMenu.getRoleId());
                roleMenu.setRole(roleService.get(role));

                Menu menu = new Menu();
                menu.setId(roleMenu.getMenuId());
                roleMenu.setMenu(menuService.get(menu));
            }
        }
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
