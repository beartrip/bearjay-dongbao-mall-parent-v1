package com.edu.bearjay.dongbao.common.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于 token检测
 * @author langyixiong
 * @date 2021/5/7 14:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {
    boolean required() default true;
}
