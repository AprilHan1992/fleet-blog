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
 */
public class User extends Base {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名（登录使用）
     */
    private String userName;

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
    private String userPwd;

    /**
     * 密码加盐
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwdSalt;

    /**
     * 单设备登录（0：否，1：是）
     */
    private Integer single;

    /**
     * 用户状态（0：禁用，1：正常，2：未验证，3：锁定）
     */
    private Integer userState;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date userRegTime;

    private Dept userDept;

    private List<Role> userRoleList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Integer getSingle() {
        return single;
    }

    public void setSingle(Integer single) {
        this.single = single;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Date getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
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
