package com.mmd.mmdshop.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




public class SessionInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("开始请求地址拦截"+request.getServletPath());
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("userId") != null) {
            return true;
        } else {
            response.sendRedirect("/backstageLogin/index.html");
            return false;
        }
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("返回视图或String之前的处理1");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("返回视图或String之前的处理2");
	}

}
