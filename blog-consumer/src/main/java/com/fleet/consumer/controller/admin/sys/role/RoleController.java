package com.fleet.consumer.controller.admin.sys.role;

import com.fleet.common.entity.role.Role;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.role.RoleService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Reference
    private RoleService roleService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Role role) {
        roleService.insert(role);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("roleId") Integer roleId) {
        Role role = new Role();
        role.setRoleId(roleId);
        roleService.delete(role);
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("roleIds") List<Integer> roleIds) {
        for (Integer roleId : roleIds) {
            Role role = new Role();
            role.setRoleId(roleId);
            roleService.delete(role);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Role role) {
        roleService.update(role);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("roleId") Integer roleId) {
        Role role = new Role();
        role.setRoleId(roleId);
        return R.ok(roleService.get(role));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(roleService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Role> listPage(@RequestBody Page page) {
        PageUtil<Role> pageUtil = new PageUtil<>();
        List<Role> list = roleService.list(page);
        list = roleService.buildTree(list);
        page.setTotalRows(list.size());

        pageUtil.setList(list.subList(page.getFromPageIndex(), page.getToPageIndex()));
        pageUtil.setPage(page);
        return pageUtil;
    }

}
