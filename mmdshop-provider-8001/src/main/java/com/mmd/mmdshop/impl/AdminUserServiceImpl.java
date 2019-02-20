package com.mmd.mmdshop.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.mapper.AdminUserMapper;
import com.mmd.mmdshop.mapper.ChangeTypeMapper;
import com.mmd.mmdshop.result.AdminUserAll;
import com.mmd.mmdshop.result.AdminUserLoginResult;
import com.mmd.mmdshop.service.AdminUserService;

/**
 * 后台管理用户业务类
 * 
 * @author QJH
 * @version 1.0
 * @date 2018/2/18
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdminUserMapper mapper;
	@Autowired
	private ChangeTypeMapper cmapper;
	
	@Override
	public AdminUserLoginResult doLogin(int username, String password, String ip) {
		/**
		 * 通过userName查询password和userId
		 */
		QueryWrapper<AdminUserDO> adminUserWrapper = new QueryWrapper<AdminUserDO>();
		adminUserWrapper.select("password", "user_id").eq("username", username);
		
		// 通过adminUserWrapper获取mybatisPlus返回的AdminUserDO对象
		AdminUserDO adminUserDo = mapper.selectOne(adminUserWrapper);

		/**
		 * 对adminUserDo的账号密码进行判断
		 */
		if (adminUserDo != null && adminUserDo.getPassword().equals(password)) {
			// 获取用户Id
			int userId = adminUserDo.getUserId();

			AdminUserLoginResult adminUserLoginResult = mapper.getAdminUserLoginResultByUserId(userId, ip);

			return adminUserLoginResult;
		}
		return null;
	}

	@Override
	public AdminUserAll findAdminUserAllByUsername(String username) {
		return mapper.getAdminUserAllByUsername(username);
	}

}
