package com.mmd.mmdshop.service;

import com.mmd.mmdshop.result.*;

/**
 * 后端管理用户逻辑层接口
 * 
 * @author MM
 * @ClassName AdminUserService.java
 * @version 1.0
 * @date 2019/2/18
 */
public interface AdminUserService {

	/**
	 * 后台用户登录
	 * 
	 * @param username
	 * @param password
	 * @param ip
	 * @return
	 */
	AdminUserLoginResult doLogin(int username, String password, String ip);

	/**
	 * 通过用户名查找用户全部信息
	 * 
	 * @param username
	 * @return 用户全部信息封装类
	 */
	AdminUserAll findAdminUserAllByUsername(String username);

	/**
	 * 数据库新加入一个后台管理用户
	 * 
	 * @param adminUserAll
	 *            用户全部信息封装类
	 * @return
	 */
	boolean addAdminUserAll(AdminUserAll adminUserAll);

	/**
	 * 修改一个后台管理用户
	 * 
	 * @param adminUserAll
	 *            用户全部信息封装类
	 * @return
	 */
	boolean modifyAdminUserAll(AdminUserAll adminUserAll);
	
	/**
	 * 通过用户名字删除后台管理用户
	 * 
	 * @param username 用户名
	 * @return 
	 */
	boolean removeAdminUserAll(String username);
}
