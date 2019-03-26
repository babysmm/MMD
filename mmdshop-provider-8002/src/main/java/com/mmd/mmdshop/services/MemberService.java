package com.mmd.mmdshop.services;

import com.mmd.mmdshop.result.member.MemberIndexInitResult;

import net.sf.json.JSONObject;

public interface MemberService {
	/**
	 * 会员登录
	 * @param result
	 * @return
	 */
	String memberLogin(JSONObject result);
	
	/**
	 * 首页初始化
	 * @return
	 * @throws Exception 
	 */
	MemberIndexInitResult findMemberIndexInitResult() throws Exception;
}
