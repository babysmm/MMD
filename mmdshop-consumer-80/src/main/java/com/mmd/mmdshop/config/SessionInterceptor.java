package com.mmd.mmdshop.config;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * @ClassName SessionInterceptor.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
public class SessionInterceptor implements HandlerInterceptor {	
	HashMap<String,Integer> map;
	
	SessionInterceptor() {
		map=new HashMap<String,Integer>();
		
		map.put("staffUserLogin", 1);
		map.put("searchCommodity", 1);
		map.put("findShopStaffByfullName", 2);
		map.put("findShopStaffByusername", 2);
		map.put("addShopStaff", 2);
		map.put("modifyShopStaff", 2);
		map.put("removeShopStaff", 2);
		map.put("sendEmailCode", 2);
		map.put("addCommodity", 2);
		map.put("modifyCommodity", 2);
		map.put("searchCommodityDOByBarCode", 3);
		map.put("searchCommodityDOByName", 3);
		map.put("memberLoginHSessionKey", 4);
	}
	
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        requestPath = requestPath.replace("/consumer/", "");
        
        boolean result = true;
        
        if(session.getAttribute("userId") == null) {
        	result = false;
        }else {
        	
        	switch(map.get(requestPath)) {
	        	//是否是商店员工
	        	case 1:if(session.getAttribute("shopStaffType") == null) result = false;break;
	        	//是否是商店店员
	        	case 2:if((int)session.getAttribute("shopStaffType") == 2) result = false;break;
	        	//查询商品
	        	case 3:if(session.getAttribute("userId") == null)result = false;break;
	        	//会员
	        	case 4:if(session.getAttribute("openID") == null)result = false;break;
	        	
	        	default :result = false;break;
        	}
        	
        }
        
        //result = true;
        
        if(result == false) {
        	this.error(request, response, handler);
            return false;
        }else {
        	return true;
        }
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
	
	private void error(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		response.sendRedirect("/backstageLogin/index.html");
	}

}
