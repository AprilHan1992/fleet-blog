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
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色
     */
    private Role role;

    /**
     * 菜单id
     */
    private Integer menuId;

    /**
     * 菜单
     */
    private Menu menu;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
