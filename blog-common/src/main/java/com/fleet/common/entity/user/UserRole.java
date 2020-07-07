package com.fleet.common.entity.user;

import com.fleet.common.entity.Base;

public class UserRole extends Base {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
