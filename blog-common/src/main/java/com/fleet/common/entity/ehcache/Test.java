package com.fleet.common.entity.ehcache;

import com.fleet.common.entity.Base;

public class Test extends Base {

    private static final long serialVersionUID = 187371427260897374L;

    private Long id;

    private String test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
