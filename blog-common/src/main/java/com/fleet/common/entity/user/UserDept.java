package com.fleet.common.entity.user;

import com.fleet.common.entity.Base;
import com.fleet.common.entity.dept.Dept;

public class UserDept extends Base {

    private static final long serialVersionUID = -8532522385874555467L;

    /**
     * 用户对应部门id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户
     */
    private User user;

    /**
     * 部门id
     */
    private Long deptId;

    private Dept dept;

    /**
     * 用户身份（普通，上级）
     */
    private String identity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
