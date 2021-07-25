package com.edu.bearjay.dongbao.common.base.enums;

/**
 * @author langyixiong
 * @date 2021/5/6 14:34
 */
public enum StateCodeEnum {
    USER_DUPLICATE(1000, "用户名重复"),
    PASSWORD_ERROR(1001, "密码错误"),
    USER_EMPTY(1002, "用户不存在"),
    TOKEN_EXCEPTION(1100, "token异常"),
    FAIL(500, "请求失败"),
    SUCCESS(200, "请求成功");

    private int code;
    private String msg;

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
