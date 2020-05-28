package com.fleet.common.entity.article;

import com.fleet.common.entity.Base;

public class Tag extends Base {

    private static final long serialVersionUID = 7855463865888584657L;

    /**
     * 分类/标签id
     */
    private Integer tagId;

    /**
     * 类型（1：分类，2：标签）
     */
    private Integer tagType;

    /**
     * 分类/标签
     */
    private String tag;

    /**
     * 排序（数字越大，越排前）
     */
    private Integer sortValue;

    /**
     * 上一级分类/标签id
     */
    private Integer upperId;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTagType() {
        return tagType;
    }

    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public Integer getUpperId() {
        return upperId;
    }

    public void setUpperId(Integer upperId) {
        this.upperId = upperId;
    }
}
