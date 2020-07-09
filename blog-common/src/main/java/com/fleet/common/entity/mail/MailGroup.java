package com.fleet.common.entity.mail;

import com.fleet.common.entity.Base;

public class MailGroup extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱组id
     */
    private Integer id;

    /**
     * 邮箱组名称
     */
    private String name;

    /**
     * 邮箱（多个邮箱之间用","隔开）
     */
    private String tos;

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

    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }
}
