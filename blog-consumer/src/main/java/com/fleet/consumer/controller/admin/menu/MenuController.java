package com.fleet.consumer.controller.admin.menu;

import com.fleet.common.entity.menu.Menu;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.menu.MenuService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Reference
    private MenuService menuService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Menu menu) {
        menuService.insert(menu);
        return R.ok();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("menuId") Integer menuId) {
        Menu menu = new Menu();
        menu.setMenuId(menuId);
        menuService.delete(menu);
        return R.ok();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("menuIds") List<Integer> menuIds) {
        for (Integer menuId : menuIds) {
            Menu menu = new Menu();
            menu.setMenuId(menuId);
            menuService.delete(menu);
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Menu menu) {
        menuService.update(menu);
        return R.ok();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R get(@RequestParam("menuId") Integer menuId) {
        Menu menu = new Menu();
        menu.setMenuId(menuId);
        return R.ok(menuService.get(menu));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(menuService.list(map));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageUtil<Menu> listPage(@RequestBody Page page) {
        PageUtil<Menu> pageUtil = new PageUtil<>();
        List<Menu> list = menuService.list(page);
        list = menuService.buildTree(list);
        page.setTotalRows(list.size());

        pageUtil.setList(list.subList(page.getFromPageIndex(), page.getToPageIndex()));
        pageUtil.setPage(page);
        return pageUtil;
    }
}
