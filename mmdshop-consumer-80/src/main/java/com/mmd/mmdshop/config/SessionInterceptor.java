package com.mmd.mmdshop.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


<<<<<<< HEAD

/**
 * 
 * @ClassName SessionInterceptor.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
=======
>>>>>>> d7e69f43594d178de4114880955737a167083d98
public class SessionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("开始请求地址拦截"+request.getServletPath());
        HttpSession session = request.getSession(false);
        
<<<<<<< HEAD
        //System.out.println(session.getAttribute("userId"));
        
=======
>>>>>>> d7e69f43594d178de4114880955737a167083d98
        if (session != null && session.getAttribute("userId") != null) {
            return true;
        } else {
            response.sendRedirect("/backstageLogin/index.html");
            return false;
        }
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("返回视图或String之前的处理1");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("返回视图或String之前的处理2");
	}

}
