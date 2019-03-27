package com.mmd.mmdshop.services;

import org.springframework.stereotype.Service;

import com.mmd.mmdshop.result.member.MemberIndexInitResult;
import com.mmd.mmdshop.result.member.WXUserInfo;

import net.sf.json.JSONObject;

public interface MemberService {
	/**
	 * 会员登录
	 * @param result
	 * @return
	 */
	JSONObject memberLogin(JSONObject result);
	
	/**
	 * 首页初始化
	 * @return
	 * @throws Exception 
	 */
	MemberIndexInitResult findMemberIndexInitResult() throws Exception;
	
	/**
	 * 更新用户信息
	 * @param info
	 * @return
	 */
	boolean modityMemberWXInfo(WXUserInfo info);
}
