package com.fleet.common.controller;

import com.fleet.common.entity.user.User;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 公共 controller
 *
 * @author April Han
 */
@RestController
public abstract class BaseController<T> {

    public abstract BaseService<T> baseService();

    public User getUser() {
        return CurUser.getUser();
    }

    public Integer getUserId() {
        User user = getUser();
        if (user == null) {
            return null;
        }
        return getUser().getId();
    }

    @PostMapping("/insert")
    public R insert(@RequestBody T t) {
        if (!baseService().insert(t)) {
            return R.error();
        }
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody T t) {
        if (!baseService().delete(t)) {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping(value = "/deletes", method = {RequestMethod.GET, RequestMethod.POST})
    public R deletes(@RequestParam Integer[] ids) {
        if (!baseService().deletes(ids)) {
            return R.error();
        }
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestBody T t) {
        if (!baseService().update(t)) {
            return R.error();
        }
        return R.ok();
    }

    @PostMapping("/get")
    public R get(@RequestBody T t) {
        return R.ok(baseService().get(t));
    }

    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(baseService().list(map));
    }

    @PostMapping("/listPage")
    public PageUtil<T> listPage(@RequestBody Page page) {
        return baseService().listPage(page);
    }
}
