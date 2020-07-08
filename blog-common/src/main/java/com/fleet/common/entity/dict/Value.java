package com.fleet.common.entity.dict;

import com.fleet.common.entity.Base;

/**
 * @author April Han
 */
public class Value extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 字典值id
     */
    private Integer id;

    /**
     * 字典id
     */
    private Integer dictId;

    /**
     * 字典标签
     */
    private String code;

    /**
     * 字典值
     */
    private String value;

    /**
     * 字典值描述
     */
    private String remark;

    /**
     * 排序（数字越大，越排前）
     */
    private Integer sort;

    /**
     * 是否是默认值（1：是，0：否）
     */
    private Integer isDefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
