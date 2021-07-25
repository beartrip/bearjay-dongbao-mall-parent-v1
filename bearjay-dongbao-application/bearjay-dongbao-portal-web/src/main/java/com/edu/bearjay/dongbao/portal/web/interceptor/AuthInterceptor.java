package com.edu.bearjay.dongbao.portal.web.interceptor;

import com.edu.bearjay.dongbao.common.base.annotation.TokenCheck;
import com.edu.bearjay.dongbao.common.util.utils.JwtUtil;
import com.edu.bearjay.dongbao.portal.web.exception.TokenException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author langyixiong
 * @date 2021/5/7 14:14
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new TokenException("token为空");
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if (annotation.required()) {
                try {
                    JwtUtil.parseToken(token);
                } catch (Exception e) {
                    throw new TokenException("token解析异常");
                }
            }
        }
        return true;
    }
}
