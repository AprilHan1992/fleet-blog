package com.fleet.consumer.controller.admin.user;

import com.fleet.common.entity.user.UserDept;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/dept")
public class UserDeptController {

    @Reference
    private UserDeptService userDeptService;

    @RequestMapping("/insert")
    public R insert(UserDept userDept) {
        UserDept ud = new UserDept();
        ud.setId(userDept.getId());
        userDeptService.delete(ud);
        if (userDeptService.insert(userDept)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody UserDept userDept) {
        if (userDeptService.delete(userDept)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    public R deleteBatch(@RequestBody List<UserDept> userDeptList) {
        for (UserDept userDept : userDeptList) {
            if (!userDeptService.delete(userDept)) {
                return R.error();
            }
        }
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody UserDept userDept) {
        UserDept ud = new UserDept();
        ud.setId(userDept.getId());
        userDeptService.delete(ud);
        if (userDeptService.update(userDept)) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/get")
    public R get(@RequestBody UserDept userDept) {
        return R.ok(userDeptService.get(userDept));
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        return R.ok(userDeptService.list(map));
    }

    @RequestMapping("/listPage")
    public PageUtil<UserDept> listPage(@RequestBody Page page) {
        return userDeptService.listPage(page);
    }

}
