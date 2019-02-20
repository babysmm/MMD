package com.mmd.mmdshop.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.result.AdminUserAll;
import com.mmd.mmdshop.result.AdminUserLoginResult;
import com.mmd.mmdshop.service.AdminUserService;
import com.mmd.mmdshop.vo.AdminUserLoginVO;

/**
 * 
 * @ClassName AdminUserController.java
 * @author QJH
 * @version 1.0
 * @date 2019/2/18
 */

@RestController
public class AdminUserController{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdminUserService adminUserservice;
	

	@PostMapping("/provider/adminUserLogin")
	public AdminUserLoginResult adminUserLogin(@RequestBody AdminUserLoginVO vo) {
		return adminUserservice.doLogin(vo.getUsername(), vo.getPassword(), vo.getLastIp());
	}
	
	@PostMapping("/provider/findAdminUserAll")
	public AdminUserAll findUserAllZ(@RequestBody String username) {
		return adminUserservice.findAdminUserAllByUsername(username);
	}
}
