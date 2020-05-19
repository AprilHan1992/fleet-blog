package com.fleet.common.entity.dict;

import com.fleet.common.entity.Base;

import java.util.List;

public class Dict extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 字典id
     */
    private Integer dictId;

    /**
     * 字典组
     */
    private String dictGroup;

    /**
     * 字典组描述
     */
    private String dictRemark;

    private List<DictValue> dictValueList;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictGroup() {
        return dictGroup;
    }

    public void setDictGroup(String dictGroup) {
        this.dictGroup = dictGroup;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    public List<DictValue> getDictValueList() {
        return dictValueList;
    }

    public void setDictValueList(List<DictValue> dictValueList) {
        this.dictValueList = dictValueList;
    }

}
