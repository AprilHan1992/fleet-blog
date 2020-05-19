package com.fleet.common.exception;

import com.fleet.common.enums.ResultState;

import java.io.Serializable;

public class TestException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -892871399041932941L;

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

    public TestException() {
        super(ResultState.ERROR.getMsg());
        this.code = ResultState.ERROR.getCode();
        this.msg = ResultState.ERROR.getMsg();
    }

    public TestException(String msg) {
        super(msg);
        this.code = ResultState.ERROR.getCode();
        this.msg = msg;
    }

    public TestException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public TestException(ResultState resultState) {
        super(resultState.getMsg());
        this.code = resultState.getCode();
        this.msg = resultState.getMsg();
    }

    public TestException(ResultState resultState, String msg) {
        super(msg);
        this.code = resultState.getCode();
        this.msg = msg;
    }
}
