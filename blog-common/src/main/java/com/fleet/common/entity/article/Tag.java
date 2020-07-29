package com.fleet.common.entity.article;

import com.fleet.common.entity.Base;

/**
 * @author April Han
 */
public class Tag extends Base {

    private static final long serialVersionUID = 7855463865888584657L;

    /**
     * 分类/标签id
     */
    private Long id;

    /**
     * 类型（1：分类，2：标签）
     */
    private Integer type;

    /**
     * 分类/标签
     */
    private String tag;

    /**
     * 排序（数字越大，越排前）
     */
    private Integer sort;

    /**
     * 上一级分类/标签id
     */
    private Long upperId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getUpperId() {
        return upperId;
    }

    public void setUpperId(Long upperId) {
        this.upperId = upperId;
    }
}
