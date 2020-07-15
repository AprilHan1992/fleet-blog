package com.fleet.consumer.controller.admin.user;

import com.fleet.common.controller.BaseController;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.user.User;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.enums.Deleted;
import com.fleet.common.json.R;
import com.fleet.common.service.BaseService;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.common.service.user.UserService;
import com.fleet.common.util.jdbc.PageUtil;
import com.fleet.common.util.jdbc.entity.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@RestController
@RequestMapping("/user/dept")
public class UserDeptController extends BaseController<UserDept> {

    @Reference
    private UserDeptService userDeptService;

    @Reference
    private UserService userService;

    @Reference
    private DeptService deptService;

    @Override
    public BaseService<UserDept> baseService() {
        return userDeptService;
    }

    @RequestMapping("/get")
    public R get(@RequestParam("id") Integer id) {
        UserDept userDept = new UserDept();
        userDept.setId(id);
        return get(userDept);
    }

    @Override
    @RequestMapping("/get")
    public R get(@RequestBody UserDept userDept) {
        userDept = userDeptService.get(userDept);
        if (userDept != null) {
            User user = new User();
            user.setId(userDept.getUserId());
            userDept.setUser(userService.get(user));

            Dept dept = new Dept();
            dept.setId(userDept.getDeptId());
            userDept.setDept(deptService.get(dept));
        }
        return R.ok(userDept);
    }

    @Override
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> map) {
        map.put("deleted", Deleted.NO);
        List<UserDept> list = userDeptService.list(map);
        if (list != null) {
            for (UserDept userDept : list) {
                User user = new User();
                user.setId(userDept.getUserId());
                userDept.setUser(userService.get(user));

                Dept dept = new Dept();
                dept.setId(userDept.getDeptId());
                userDept.setDept(deptService.get(dept));
            }
        }
        return R.ok(list);
    }

    @Override
    @PostMapping("/listPage")
    public PageUtil<UserDept> listPage(@RequestBody Page page) {
        PageUtil<UserDept> pageUtil = userDeptService.listPage(page);
        List<UserDept> list = pageUtil.getList();
        if (list != null) {
            for (UserDept userDept : list) {
                User user = new User();
                user.setId(userDept.getUserId());
                userDept.setUser(userService.get(user));

                Dept dept = new Dept();
                dept.setId(userDept.getDeptId());
                userDept.setDept(deptService.get(dept));
            }
        }
        return pageUtil;
    }
}
