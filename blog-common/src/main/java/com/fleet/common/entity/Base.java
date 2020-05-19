package com.fleet.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fleet.common.enums.Deleted;

import java.io.Serializable;

/**
 * 公共对象（数据的逻辑删除，防止物理删除）
 */
public class Base implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否删除（1：是，0：否）
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer deleted = Deleted.NO;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
