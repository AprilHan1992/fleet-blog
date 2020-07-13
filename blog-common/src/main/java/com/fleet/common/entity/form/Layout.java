package com.fleet.common.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;

import java.util.Date;

/**
 * 布局设计
 */
public class Layout extends Base {

    private static final long serialVersionUID = 7452443340884422468L;

    /**
     * 布局ID
     */
    private Integer layoutId;

    /**
     * 布局类型（1：web，2：手机）
     */
    private Integer layoutType;

    /**
     * 布局标识
     */
    private String layoutKey;

    /**
     * 布局名称
     */
    private String layoutName;

    /**
     * 布局备注
     */
    private String layoutRemark;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date layoutCreateTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date layoutEditTime;

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(Integer layoutType) {
        this.layoutType = layoutType;
    }

    public String getLayoutKey() {
        return layoutKey;
    }

    public void setLayoutKey(String layoutKey) {
        this.layoutKey = layoutKey;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public String getLayoutRemark() {
        return layoutRemark;
    }

    public void setLayoutRemark(String layoutRemark) {
        this.layoutRemark = layoutRemark;
    }

    public Date getLayoutCreateTime() {
        return layoutCreateTime;
    }

    public void setLayoutCreateTime(Date layoutCreateTime) {
        this.layoutCreateTime = layoutCreateTime;
    }

    public Date getLayoutEditTime() {
        return layoutEditTime;
    }

    public void setLayoutEditTime(Date layoutEditTime) {
        this.layoutEditTime = layoutEditTime;
    }
}
