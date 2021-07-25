package com.edu.bearjay.dongbao.common.base.result;

import com.edu.bearjay.dongbao.common.base.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author langyixiong
 * @date 2021/5/6 14:39
 */
@Data
@Builder
public class ResponseResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static ResponseResult.ResponseResultBuilder getSuccessBuilder() {
        return ResponseResult.builder()
                .code(StateCodeEnum.SUCCESS.getCode())
                .msg(StateCodeEnum.SUCCESS.getMsg());
    }

    public static ResponseResult.ResponseResultBuilder getFailBuilder() {
        return ResponseResult.builder()
                .code(StateCodeEnum.FAIL.getCode())
                .msg(StateCodeEnum.FAIL.getMsg());
    }
}
