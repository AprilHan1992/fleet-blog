package com.fleet.consumer.controller.admin.menu;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.menu.Menu;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.menu.MenuService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu> {

    @Reference
    private MenuService menuService;

    @Override
    public BaseService<Menu> baseService() {
        return menuService;
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        Menu menu = new Menu();
        menu.setId(id);
        return get(menu);
    }

    @Override
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        List<Menu> list = menuService.list(map);
        list = menuService.buildTree(list);
        return R.ok(list);
    }

    @Override
    @PostMapping("/listPage")
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
