package com.fleet.common.entity.role;

import com.fleet.common.entity.Base;
import com.fleet.common.entity.menu.Menu;

/**
 * @author April Han
 */
public class RoleMenu extends Base {

    private static final long serialVersionUID = -398629241498441228L;

    /**
     * 角色对应菜单id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色
     */
    private Role role;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 菜单
     */
    private Menu menu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
