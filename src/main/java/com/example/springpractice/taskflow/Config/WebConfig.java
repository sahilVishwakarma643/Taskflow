package com.example.springpractice.taskflow.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springpractice.taskflow.Interceptors.RequestDebugInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    private final RequestDebugInterceptor requestDebugInterceptor;

    public WebConfig(RequestDebugInterceptor requestDebugInterceptor)
    {
        this.requestDebugInterceptor=requestDebugInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
    registry.addInterceptor(requestDebugInterceptor);
}
}
