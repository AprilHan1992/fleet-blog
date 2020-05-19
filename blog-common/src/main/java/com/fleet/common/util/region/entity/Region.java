package com.fleet.common.util.region.entity;

import java.io.Serializable;

public class Region implements Serializable {

    private static final long serialVersionUID = -234021727351069994L;

    private String country;

    private String province;

    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
