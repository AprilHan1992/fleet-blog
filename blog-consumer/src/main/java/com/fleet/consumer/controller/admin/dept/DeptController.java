package com.fleet.consumer.controller.admin.dept;

import com.fleet.common.entity.dept.Dept;
import com.fleet.common.json.R;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Reference
    private DeptService deptService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody Dept dept) {
        dept.setCreateTime(new Date());
        if (deptService.insert(dept)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public R delete(@RequestParam("deptId") Integer deptId) {
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        if (deptService.delete(dept)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping(value = "/delete/batch", method = {RequestMethod.GET, RequestMethod.POST})
    public R deleteBatch(@RequestParam("deptIds") List<Integer> deptIds) {
        for (Integer deptId : deptIds) {
            Dept dept = new Dept();
            dept.setDeptId(deptId);
            if (!deptService.delete(dept)) {
                return R.error();
            }
        }
        return R.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody Dept dept) {
        dept.setEditTime(new Date());
        if (deptService.update(dept)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Dept get(@RequestParam("deptId") Integer deptId) {
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        dept = deptService.get(dept);
        return dept;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Dept get(@RequestBody Dept dept) {
        dept = deptService.get(dept);
        return dept;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", 0);
        List<Dept> list = deptService.list(map);
        return R.ok(list);
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
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
