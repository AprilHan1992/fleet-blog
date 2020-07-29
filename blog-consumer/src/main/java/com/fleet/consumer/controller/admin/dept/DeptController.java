package com.fleet.consumer.controller.admin.dept;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 * @author April Han
 */
@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController<Dept> {

    @Reference
    private DeptService deptService;

    @Override
    public BaseService<Dept> baseService() {
        return deptService;
    }

    @Override
    @PostMapping("/insert")
    public R insert(@RequestBody Dept dept) {
        if (dept.getUpperId() == null) {
            dept.setUpperId(0L);
        }
        dept.setCreatorId(getUserId());
        dept.setCreateTime(new Date());
        if (!deptService.insert(dept)) {
            return R.error();
        }
        return R.ok();
    }

    @Override
    @PostMapping("/update")
    public R update(@RequestBody Dept dept) {
        dept.setEditorId(getUserId());
        dept.setEditTime(new Date());
        if (!deptService.update(dept)) {
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/get")
    public R get(@RequestParam("id") Long id) {
        Dept dept = new Dept();
        dept.setId(id);
        return get(dept);
    }

    @Override
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        List<Dept> list = deptService.list(map);
        list = deptService.buildTree(list);
        return R.ok(list);
    }

    @Override
    @PostMapping("/listPage")
    public PageUtil<Dept> listPage(@RequestBody Page page) {
        PageUtil<Dept> pageUtil = new PageUtil<>();
        List<Dept> list = deptService.list(page);
        list = deptService.buildTree(list);
        page.setTotalRows(list.size());

        pageUtil.setList(list.subList(page.getFromPageIndex(), page.getToPageIndex()));
        pageUtil.setPage(page);
        return pageUtil;
    }
}
