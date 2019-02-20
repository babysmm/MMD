package com.mmd.mmdshop.controller;

import java.io.IOException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.AdminUserAll;
import com.mmd.mmdshop.result.AdminUserLoginResult;
import com.mmd.mmdshop.vo.AdminUserLoginVO;

/**
	* 
	* @ClassName AdminUserLoginController_Consumer.java
	* @author QJH
	* @version 1.0
	* @date 2019/2/18
*/
@RestController
public class AdminUserController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;

	
	@PostMapping("/consumer/adminUserLogin")
	public String adminUserLogin(AdminUserLoginVO vo,HttpServletRequest request) throws IOException {
		
		vo.setLastIP(request);
		
		logger.info(vo.toString());
		
		AdminUserLoginResult result = template.postForObject(ADMINUSERPROVIDER_URL+"/adminUserLogin", vo, AdminUserLoginResult.class);
		
		if(result == null)return null;
		
		request.getSession().setAttribute("userId", result.getUserId());
		
		return result.getFullName();
	}
	
	@PostMapping("/consumer/findAdminUserAll")
	public AdminUserAll findAdminUserAll(String username) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/findAdminUserAll", username, AdminUserAll.class);
	}
}
