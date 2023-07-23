package com.quotalab.snsclone.global.interceptor;

import com.quotalab.snsclone.global.annotation.AuthenticationCheck;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       if(!(handler instanceof HandlerMethod)) {
           return true;
       }

       if(request.getMethod().equals("OPTIONS")) return true;

       HandlerMethod handlerMethod = (HandlerMethod) handler;
       AuthenticationCheck authenticationAnnotation = handlerMethod.getMethodAnnotation(AuthenticationCheck.class);

       if(authenticationAnnotation == null) {
           return true;
       }


        return true;
    }
}
