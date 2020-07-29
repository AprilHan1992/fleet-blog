package com.fleet.common.entity.dict;

import com.fleet.common.entity.Base;

import java.util.List;

/**
 * @author April Han
 */
public class Dict extends Base {

    private static final long serialVersionUID = -5626663637379233824L;

    /**
     * 字典id
     */
    private Long id;

    /**
     * 字典组
     */
    private String group;

    /**
     * 字典组描述
     */
    private String remark;

    private List<Value> valueList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }
}
