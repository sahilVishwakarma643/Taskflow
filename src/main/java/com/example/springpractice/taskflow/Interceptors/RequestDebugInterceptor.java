package com.example.springpractice.taskflow.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestDebugInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    )
    {
        System.out.println("Interceptor is triggered");
        return true;
    }
}
