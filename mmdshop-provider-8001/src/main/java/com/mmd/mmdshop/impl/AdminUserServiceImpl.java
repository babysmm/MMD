package com.mmd.mmdshop.impl;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.mapper.AdminUserMapper;
import com.mmd.mmdshop.result.AdminUserAll;
import com.mmd.mmdshop.result.AdminUserLoginResult;
import com.mmd.mmdshop.service.AdminUserService;

/**
 * 
 * @ClassName AdminUserServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout=10)
@Service
public class AdminUserServiceImpl implements AdminUserService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdminUserMapper mapper;
	
	@Override
	public AdminUserLoginResult doLogin(int username, String password, String ip) {
		
		// 通过userName查询password和userId
		QueryWrapper<AdminUserDO> adminUserWrapper = new QueryWrapper<AdminUserDO>();
		adminUserWrapper.select("password", "user_id").eq("username", username);
		
		// 通过adminUserWrapper获取mybatisPlus返回的AdminUserDO对象
		AdminUserDO adminUserDo = mapper.selectOne(adminUserWrapper);

		//对adminUserDo的账号密码进行判断
		if (adminUserDo != null && adminUserDo.getPassword().equals(password)) {
			// 获取用户Id
			int userId = adminUserDo.getUserId();
			// 对返回值进行封装传递给服务消费者
			AdminUserLoginResult adminUserLoginResult = mapper.getAdminUserLoginResultByUserId(userId, ip);

			return adminUserLoginResult;
		}
		return null;
	}
	
	@Override
	public AdminUserAll findAdminUserAllByUsername(String username) {
		return mapper.getAdminUserAllByUsername(username);
	}

	@Override
	public boolean addAdminUserAll(AdminUserAll adminUserAll) {
		AdminUserDO adminUserDO = adminUserAll.getAdminUserDO();
		
		mapper.insertAdminUser(adminUserDO);
		
		//获取返回Id	
		Integer userId = adminUserDO.getUserId();

		System.out.println(userId);
		
		adminUserAll.getAdminUserDetailsDO().setUserId(userId);
		adminUserAll.getAdminUserJurisdictionDO().setUserId(userId);
			
		return mapper.insertAdminUserDetailAndJur(adminUserAll);
	}
	
	@Override
	public boolean modifyAdminUserAll(AdminUserAll adminUserAll) {
		AdminUserDO adminUserDO = adminUserAll.getAdminUserDO();
		
		logger.info(adminUserAll.toString());
		
		QueryWrapper<AdminUserDO> adminUserWrapper = new QueryWrapper<AdminUserDO>();
		adminUserWrapper.select("user_id").eq("username", adminUserDO.getUsername());
		
		adminUserDO.setUserId(mapper.selectOne(adminUserWrapper).getUserId());
		
		return mapper.upDataAdminUserAll(adminUserAll);
	}
	
	@Override
	public boolean removeAdminUserAll(String username) {
		QueryWrapper<AdminUserDO> adminUserWrapper = new QueryWrapper<AdminUserDO>();
		adminUserWrapper.select("user_id").eq("username", username);
		
		Integer userId = mapper.selectOne(adminUserWrapper).getUserId();
		
		try {
			return mapper.deleteAdminUserAllByUserId(userId);
		}catch(Exception e) {
			return false;
		}
	}
}
