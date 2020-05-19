package com.fleet.common.entity.dict;

import com.fleet.common.entity.Base;

public class DictValue extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 字典值id
     */
    private Integer dictValueId;

    /**
     * 字典id
     */
    private Integer dictId;

    /**
     * 字典标签
     */
    private String dictValueCode;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 字典值描述
     */
    private String dictValueRemark;

    /**
     * 排序（数字越大，越排前）
     */
    private Integer sortValue;

    /**
     * 是否是默认值（1：是，0：否）
     */
    private Integer isDefault;

    public Integer getDictValueId() {
        return dictValueId;
    }

    public void setDictValueId(Integer dictValueId) {
        this.dictValueId = dictValueId;
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictValueCode() {
        return dictValueCode;
    }

    public void setDictValueCode(String dictValueCode) {
        this.dictValueCode = dictValueCode;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictValueRemark() {
        return dictValueRemark;
    }

    public void setDictValueRemark(String dictValueRemark) {
        this.dictValueRemark = dictValueRemark;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

}
