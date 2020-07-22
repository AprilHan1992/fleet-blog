package com.fleet.consumer.controller.admin.role;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.entity.role.Role;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {

    @Reference
    private RoleService roleService;

    @Reference
    private RoleMenuService roleMenuService;

    @Reference
    private MenuService menuService;

    @Override
    public BaseService<Role> baseService() {
        return roleService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        Role role = new Role();
        role.setId(id);
        return get(role);
    }

    @Override
    @PostMapping("/get")
    public R get(@RequestBody Role role) {
        role = roleService.get(role);
        if (role != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("deleted", Deleted.NO);
            map.put("roleId", role.getId());
            role.setRoleMenuList(roleMenuService.list(map));

            List<Menu> menuList = roleMenuService.menuList(role.getId());
            role.setMenuList(menuService.buildTree(menuList));
        }
        return R.ok(role);
    }

    @Override
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        List<Role> list = roleService.list(map);
        list = roleService.buildTree(list);
        if (list != null) {
            for (Role role : list) {
                Map<String, Object> m = new HashMap<>();
                m.put("deleted", Deleted.NO);
                m.put("roleId", role.getId());
                role.setRoleMenuList(roleMenuService.list(m));

                List<Menu> menuList = roleMenuService.menuList(role.getId());
                role.setMenuList(menuService.buildTree(menuList));
            }
        }
        return R.ok(list);
    }

    @Override
    @PostMapping("/listPage")
    public PageUtil<Role> listPage(@RequestBody Page page) {
        PageUtil<Role> pageUtil = new PageUtil<>();
        List<Role> list = roleService.list(page);
        if (list != null) {
            for (Role role : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("deleted", Deleted.NO);
                map.put("roleId", role.getId());
                role.setRoleMenuList(roleMenuService.list(map));

                List<Menu> menuList = roleMenuService.menuList(role.getId());
                role.setMenuList(menuService.buildTree(menuList));
            }
        }
        list = roleService.buildTree(list);
        page.setTotalRows(list.size());

        pageUtil.setList(list.subList(page.getFromPageIndex(), page.getToPageIndex()));
        pageUtil.setPage(page);
        return pageUtil;
    }
}
