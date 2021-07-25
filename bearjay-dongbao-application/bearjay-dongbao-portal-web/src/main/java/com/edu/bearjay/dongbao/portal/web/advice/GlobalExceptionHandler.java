package com.edu.bearjay.dongbao.portal.web.advice;

import com.edu.bearjay.dongbao.common.base.enums.StateCodeEnum;
import com.edu.bearjay.dongbao.common.base.result.ResponseResult;
import com.edu.bearjay.dongbao.portal.web.exception.TokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author langyixiong
 * @date 2021/5/6 16:40
 */
@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseResult arithmeticException() {
        return ResponseResult.builder().code(301).msg("自定义算术异常").build();
    }

    @ExceptionHandler(TokenException.class)
    public ResponseResult tokenException(Exception e) {
        return ResponseResult.getFailBuilder()
                .code(StateCodeEnum.TOKEN_EXCEPTION.getCode())
                .msg(e.getMessage()).build();
    }
}
