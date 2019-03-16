package com.mmd.mmdshop.controller;

import java.io.IOException;

import javax.validation.constraints.NotNull;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.AdminUserAll;
import com.mmd.mmdshop.result.AdminUserLoginResult;
import com.mmd.mmdshop.utils.ParamValidation;
import com.mmd.mmdshop.vo.AdminUserLoginVO;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName AdminUserController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class AdminUserController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";

	@Autowired
	private RestTemplate template;

	@Autowired
	private ParamValidation pv;

	/**
	 * 后台管理用户登录验证及修改时间和IP地址
	 * 
	 * @param vo
	 * @param request
	 * @return fullName 用户全名，
	 * @throws IOException
	 */
	@PostMapping("/consumer/adminUserLogin")
	public String adminUserLogin(@NotNull AdminUserLoginVO vo, HttpServletRequest request) throws IOException {
		// 数据校验
		if (vo.getUsername() == 0 || vo.getPassword().length() == 0) {
			return null;
		}
		// 加入IP
		vo.setLastIP(request);
		// 获取服务提供者返回信息
		AdminUserLoginResult result = template.postForObject(ADMINUSERPROVIDER_URL + "/adminUserLogin", vo,
				AdminUserLoginResult.class);

		if (result == null) {
			return null;
		}
		// 设置session
		request.getSession().setAttribute("userId", result.getUserId());

		return result.getFullName();
	}

	/**
	 * 后台管理员通过用户名搜索管理用户所有信息
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	@PostMapping("/consumer/findAdminUserAll")
	public AdminUserAll findAdminUserAll(@NotNull String username) {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/findAdminUserAll", username, AdminUserAll.class);
	}

	/**
	 * 新增后台管理用户
	 * 
	 * @param adminUserAll
	 *            后台管理用户全部信息
	 * @param request
	 *            HttpServletRequest
	 * @return 新增用户是否成功
	 */
	@PostMapping("/consumer/newAdminUser")
	public boolean newAdminUser(@RequestBody AdminUserAll adminUserAll, HttpServletRequest request) {
		// 对前台输入数据进行校验
		if (this.adminUserAllDataVerification(adminUserAll) == false) {
			return false;
		}

		// 设置修改用户Id
		Integer thisUserId = (Integer) request.getSession().getAttribute("userId");
		adminUserAll.getAdminUserDO().setChangeUserId(thisUserId);
		adminUserAll.getAdminUserDetailsDO().setChangeUserId(thisUserId);
		adminUserAll.getAdminUserJurisdictionDO().setChangeUserId(thisUserId);

		// System.out.println(adminUserAll);

		// 调用服务提供者
		return template.postForObject(ADMINUSERPROVIDER_URL + "/newAdminUser", adminUserAll, boolean.class);
	}

	/**
	 * 后台管理用户更新后台管理信息
	 * 
	 * @param adminUserAll
	 * @return
	 */
	@PostMapping("/consumer/modifyAdminUserAll")
	public boolean modifyAdminUserAll(@RequestBody AdminUserAll adminUserAll) {
		// 数据校验
		if (this.adminUserAllDataVerification(adminUserAll) == false) {
			return false;
		}
		// 调用服务提供者
		return template.postForObject(ADMINUSERPROVIDER_URL + "/modifyAdminUserAll", adminUserAll, boolean.class);
	}

	/**
	 * 删除用户
	 * 
	 * @param username
	 * @return
	 */
	@PostMapping("/consumer/removeAdminUserAll")
	public boolean removeAdminUserAll(@RequestBody String username) {
		JSONObject jsonObject = JSONObject.fromObject(username);
		String usernames = jsonObject.getString("username");

		// 数据校验
		if (usernames.length() == 0) {
			return false;
		}

		// 调用服务提供者
		return template.postForObject(ADMINUSERPROVIDER_URL + "/removeAdminUserAll", usernames, boolean.class);
	}

	/**
	 * 数据校验封装函数
	 * 
	 * @param adminUserAll
	 * @return
	 */
	public boolean adminUserAllDataVerification(AdminUserAll adminUserAll) {
		if (pv.isNotNull(adminUserAll.getAdminUserDO(), "username", "password") == false
				&& pv.isNotNull(adminUserAll.getAdminUserDetailsDO(), "email", "cardId", "fullName", "sex",
						"birthday") == false
				&& pv.isNotNull(adminUserAll.getAdminUserJurisdictionDO(), "jurType") == false) {
			return false;
		}
		return true;
	}
}
