package com.fleet.common.enums;

public enum ResultState {

    /**
     * 成功
     **/
    SUCCESS(0, "成功"), LOGIN_SUCCESS(0, "登录成功"), LOGOUT_SUCCESS(0, "登出成功"), SIGN_UP_SUCCESS(0, "注册成功"), FILE_EXIST(0, "文件已存在"), FILE_UPLOAD_SUCCESS(10005, "文件上传成功"),

    /**
     * 失败
     **/
    FAILED(10000, "失败"), LOGIN_FAILED(10001, "登录失败"), LOGOUT_FAILED(10002, "登出失败"), SIGN_UP_FAILED(10003, "注册失败"), LOGIN_FAILED_MORE_TIMES(10004, "登录失败次数过多"), FILE_UPLOAD_FAILED(10005, "文件上传失败"),

    /**
     * 错误
     **/
    ERROR(10100, "错误"), REQUEST_ERROR(10101, "请求错误"), REQUEST_HTTP_ERROR(10102, "需要HTTP请求"), REQUEST_HTTPS_ERROR(10103, "需要HTTPS请求"), REQUEST_GET_ERROR(10104, "需要GET请求"), REQUEST_POST_ERROR(10105, "需要POST请求"), METHOD_NOT_SUPPORTED_ERROR(10106, "请求方法不支持"), NO_HANDLER_FOUND_ERROR(10107, "请求路径错误"),
    USER_ERROR(10108, "用户错误"), ACCOUNT_PASSWORD_ERROR(10109, "账户或密码错误"), ACCOUNT_ERROR(10110, "账户错误"), PASSWORD_ERROR(10111, "密码错误"), OLD_PASSWORD_ERROR(10112, "旧密码错误"), PERMISSION_ERROR(10113, "权限验证错误"),

    /**
     * 未授权
     **/
    UNAUTHORIZED(10200, "未授权"), UNAUTHORIZED_ROLES(10201, "未授权角色"), UNAUTHORIZED_PERMITS(10202, "未授权权限"), ACCOUNT_LOCKED(10203, "用户被锁定"), ACCOUNT_NOT_ALLOWED(10204, "用户被禁用"), USER_DELETED(10205, "用户被删除"),

    /**
     * 超时
     **/
    TIMEOUT(10300, "超时"), REQUEST_TIMEOUT(10301, "请求超时"),

    /**
     * 超出限制
     **/
    OUT_OF_LIMIT(10400, "超出限制"), FILE_SIZE_OUT_OF_LIMIT(10401, "文件大小超过限制"),

    /**
     * 未找到
     **/
    NOT_FOUND(10500, "未找到"), FILE_NOT_FOUND(10501, "文件未找到"), PART_FILE_NOT_FOUND(10502, "文件部分未找到"), TEMPLATE_FILE_NOT_FOUND(10602, "模板文件未找到"),

    /**
     * 已删除
     **/
    DELETED(10600, "已删除"), APP_ID_DELETED(10701, "appId已删除"), ACCOUNT_DELETED(10702, "账户已删除"),

    /**
     * 缺少
     **/
    MISSING(10700, "缺少"), PARAM_MISSING(10801, "参数缺少"), APP_ID_MISSING(10702, "缺少appId"), APP_SECRET_MISSING(10703, "缺少appSecret"), ACCESS_TOKEN_MISSING(10704, "缺少accessToken"), REFRESH_TOKEN_MISSING(10705, "缺少refreshToken"), TIMESTAMP_MISSING(10706, "缺少timestamp"), SIGN_MISSING(10707, "缺少sign"),

    /**
     * 无效
     **/
    INVALID(10800, "无效"), PARAM_INVALID(10801, "参数无效"), APP_ID_INVALID(10802, "appId无效"), APP_SECRET_INVALID(10803, "appSecret无效"), ACCESS_TOKEN_INVALID(10804, "accessToken无效"), REFRESH_TOKEN_INVALID(10805, "refreshToken无效"), TIMESTAMP_INVALID(10806, "timestamp无效"), SIGN_INVALID(10807, "sign无效"),

    /**
     * 过期
     **/
    EXPIRE(10900, "过期"), PARAM_EXPIRE(10901, "参数过期"), APP_ID_EXPIRE(10902, "appId过期"), APP_SECRET_EXPIRE(10903, "appSecret过期"), ACCESS_TOKEN_EXPIRE(10904, "accessToken过期"), REFRESH_TOKEN_EXPIRE(10905, "refreshToken过期"), TIMESTAMP_EXPIRE(10906, "timestamp过期"), SIGN_EXPIRE(10907, "sign过期"),

    /**
     * 被篡改
     **/
    TAMPERED(11000, "被篡改"), PARAM_TAMPERED(11001, "参数被篡改"), APP_ID_TAMPERED(11002, "appId被篡改"), APP_SECRET_TAMPERED(11003, "appSecret被篡改"), ACCESS_TOKEN_TAMPERED(11004, "accessToken被篡改"), REFRESH_TOKEN_TAMPERED(11005, "refreshToken被篡改"), TIMESTAMP_TAMPERED(11006, "timestamp被篡改"), SIGN_TAMPERED(11007, "sign被篡改");

    ResultState(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
