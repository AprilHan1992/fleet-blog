package com.fleet.common.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fleet.common.entity.Base;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.entity.role.Role;

import java.util.Date;
import java.util.List;

/**
 * 用户信息
 *
 * @author April Han
 */
public class User extends Base {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 账户（登录使用）
     */
    private String name;

    /**
     * 昵称（不做登录使用）
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    /**
     * 密码加盐
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwdSalt;

    /**
     * 用户状态（0：禁用，1：正常，2：未验证，3：锁定）
     */
    private Integer state;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date regTime;

    private Dept userDept;

    private List<Role> userRoleList;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Dept getUserDept() {
        return userDept;
    }

    public void setUserDept(Dept userDept) {
        this.userDept = userDept;
    }

    public List<Role> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<Role> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
