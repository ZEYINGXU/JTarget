package com.watermelon.jtarget.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.NamedThreadLocal;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class LoginFilter implements Filter{

    NamedThreadLocal<Long> timeVar = new NamedThreadLocal<>("loginFilter");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("request url : " + httpServletRequest.getRequestURI());
        timeVar.set(System.currentTimeMillis());
        chain.doFilter(request, response);
        long time = System.currentTimeMillis();
        System.out.println("request url : " + httpServletRequest.getRequestURI() + " end! cost time : " + (time - timeVar.get())/ 1000);
        timeVar.remove();
    }

    @Override
    public void destroy() {

    }
}
