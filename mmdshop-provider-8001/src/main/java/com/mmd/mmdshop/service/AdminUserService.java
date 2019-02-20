package com.mmd.mmdshop.service;

import com.mmd.mmdshop.result.*;

/**
 * 后端管理用户逻辑层接口
 * @author QJH
 * @ClassName AdminUserService.java
 * @version 1.0
 * @date 2019/2/18
 */
public interface AdminUserService {
	
	AdminUserLoginResult doLogin(int username, String password, String ip);
	
	AdminUserAll findAdminUserAllByUsername(String username);
	
}
