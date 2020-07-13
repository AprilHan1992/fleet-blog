package com.fleet.common.entity.user;

import com.fleet.common.entity.Base;
import com.fleet.common.entity.dept.Dept;

public class UserDept extends Base {

    private static final long serialVersionUID = -8532522385874555467L;

    /**
     * 用户对应部门id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户
     */
    private User user;

    /**
     * 部门id
     */
    private Integer deptId;

    private Dept dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
