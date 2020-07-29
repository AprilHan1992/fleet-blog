package com.fleet.common.entity.user;

import com.fleet.common.entity.Base;
import com.fleet.common.entity.role.Role;

/**
 * @author April Han
 */
public class UserRole extends Base {

    private static final long serialVersionUID = 9177156814061842350L;

    /**
     * 用户对应角色id
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
     * 角色id
     */
    private Long roleId;

    /**
     * 角色
     */
    private Role role;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
