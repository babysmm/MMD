package com.mmd.mmdshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.mmdshop.services.MemberService;

import net.sf.json.JSONObject;

/**
 * 
 * @author MM
 *
 */
@RestController
public class WXMemberLoginController {
	
	@Autowired
	private MemberService service;
	
	/**
	 * 会员小程序登录
	 * @param code 小程序code
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/provider/memberLogin")
	public String memberLogin(@RequestBody JSONObject result) throws Exception {
		return service.memberLogin(result);
	}
}
