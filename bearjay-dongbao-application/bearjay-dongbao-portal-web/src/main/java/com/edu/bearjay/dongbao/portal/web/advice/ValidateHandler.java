package com.edu.bearjay.dongbao.portal.web.advice;

import com.edu.bearjay.dongbao.common.base.result.ResponseResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author langyixiong
 * @date 2021/5/6 16:00
 */
@RestControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String msg = fieldError.getDefaultMessage();
            sb.append(msg);
            break;
        }
        return new ResponseEntity<>(ResponseResult.builder().code(102).msg(sb.toString()).build(), HttpStatus.OK);
    }
}
