package com.fleet.common.entity.role;

import com.fleet.common.entity.Base;

import java.util.List;

/**
 * @author April Han
 */
public class Role extends Base {

    private static final long serialVersionUID = -2822811996935124899L;

    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 排序（数字越大，越排前）
     */
    private Integer sort;

    /**
     * 上一级角色id
     */
    private Integer upperId;

    private List<Role> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getUpperId() {
        return upperId;
    }

    public void setUpperId(Integer upperId) {
        this.upperId = upperId;
    }

    public List<Role> getChildren() {
        return children;
    }

    public void setChildren(List<Role> children) {
        this.children = children;
    }
}
